package com.realworld.user

import com.realworld.dto.SignRequest
import com.realworld.dto.UserResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

interface UserSignUseCase {
    fun signUp(signUpRequest: SignRequest.Up): UserResponse
    fun signIn(signInRequest: SignRequest.In): UserResponse
}

@Service
@Transactional(readOnly = true)
class UserSignService : UserSignUseCase {
    
    override fun signUp(signUpRequest: SignRequest.Up): UserResponse {
        TODO("Not yet implemented")
    }

    override fun signIn(signInRequest: SignRequest.In): UserResponse {
        TODO("Not yet implemented")
    }
}


