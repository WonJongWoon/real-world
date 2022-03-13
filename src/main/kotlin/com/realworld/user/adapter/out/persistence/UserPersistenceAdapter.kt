package com.realworld.user.adapter.out.persistence

import com.realworld.user.application.port.`in`.RegistrationCommand
import com.realworld.user.application.port.out.LoadUserPort
import com.realworld.user.domain.User
import org.springframework.stereotype.Component

@Component
class UserPersistenceAdapter(private val userRepository: UserRepository) : LoadUserPort {

    override fun register(registrationCommand: RegistrationCommand): User {
        TODO()
    }
}
