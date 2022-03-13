package com.realworld.user.adapter.out.persistence

import com.realworld.user.application.port.`in`.RegistrationCommand
import com.realworld.user.domain.User
import org.apache.logging.log4j.util.Strings
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class UserMapper(private val passwordEncoder: PasswordEncoder) {

    fun mapToUser(registrationDto: RegistrationCommand.RegistrationDto) = User(
        registrationDto.username,
        registrationDto.email,
        passwordEncoder.encode(registrationDto.password),
        Strings.EMPTY,
        Strings.EMPTY
    )
}
