package com.realworld.user.application.port.`in`

interface UserManagementUseCase {
    fun register(requestDto: RegistrationCommand)
}
