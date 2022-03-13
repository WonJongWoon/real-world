package com.realworld.user.adapter.out.persistence

import com.realworld.user.application.port.`in`.RegistrationCommand
import com.realworld.user.domain.User
import org.apache.logging.log4j.util.Strings
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class UserMapper(private val passwordEncoder: PasswordEncoder) {

    fun mapToUser(registrationCommand: RegistrationCommand) = User(
        registrationCommand.username,
        registrationCommand.email,
        passwordEncoder.encode(registrationCommand.password),
        Strings.EMPTY,
        Strings.EMPTY
    )
}
