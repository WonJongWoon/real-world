package com.realworld.user

import com.realworld.dto.SignRequest
import com.realworld.dto.UserResponse
import com.realworld.dto.toEntity
import com.realworld.exception.InvalidPasswordException
import com.realworld.exception.UserNotFoundException
import com.realworld.token.TokenProvider
import org.slf4j.LoggerFactory
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

interface UserSignUseCase {
    fun signUp(signUpRequest: SignRequest.Up): UserResponse
    fun signIn(signInRequest: SignRequest.In): UserResponse
}

@Service
@Transactional(readOnly = true)
class UserSignService(
    private val passwordEncoder: PasswordEncoder,
    private val userRepository: UserRepository,
    private val tokenProvider: TokenProvider
) : UserSignUseCase {

    private val log = LoggerFactory.getLogger(UserSignService::class.java)

    override fun signUp(signUpRequest: SignRequest.Up): UserResponse =
        userRepository.save(
            signUpRequest.copy(
                password = passwordEncoder.encode(signUpRequest.password)
            ).toEntity()
        ).let {
            UserResponse(
                email = it.email,
                token = tokenProvider.createToken(it.username),
                username = it.username,
                bio = it.bio,
                image = it.image
            )
        }

    override fun signIn(signInRequest: SignRequest.In): UserResponse =
        userRepository.findUserByEmail(signInRequest.email)?.let {

            if (!passwordEncoder.matches(signInRequest.password, it.password)) {
                throw InvalidPasswordException("비밀번호가 올바르지 않습니다. email = ${signInRequest.email}")
            }

            UserResponse(
                email = it.email,
                token = tokenProvider.createToken(it.username),
                username = it.username,
                bio = it.bio,
                image = it.image
            )
        } ?: throw UserNotFoundException("존재하지 않는 유저입니다. email = ${signInRequest.email}")
}
