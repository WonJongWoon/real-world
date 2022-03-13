package com.realworld.user.adapter.out.persistence

import com.realworld.user.application.port.`in`.RegistrationCommand
import com.realworld.user.application.port.out.LoadUserPort
import org.springframework.stereotype.Component

@Component
class UserPersistenceAdapter(
    private val userRepository: UserRepository,
    private val userMapper: UserMapper
) : LoadUserPort {

    override fun register(registrationCommand: RegistrationCommand) =
        userRepository.save(userMapper.mapToUser(registrationCommand))
}
