package com.realworld.user.application.port.`in`

import com.realworld.user.domain.User

interface UserManagementUseCase {
    fun register(requestDto: RegistrationCommand): User
}
