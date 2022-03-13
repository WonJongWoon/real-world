package com.realworld.user.application.service

import com.realworld.user.application.port.`in`.RegistrationCommand
import com.realworld.user.application.port.`in`.UserManagementUseCase
import com.realworld.user.application.port.out.LoadUserPort
import org.springframework.stereotype.Service

@Service
class UserManagementService(private val loadUserPort: LoadUserPort) : UserManagementUseCase {

    override fun register(requestDto: RegistrationCommand) {
        loadUserPort.register(requestDto.user)
    }
}
