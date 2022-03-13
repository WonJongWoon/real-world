package com.realworld.user.application.port.out

import com.realworld.user.application.port.`in`.RegistrationCommand
import com.realworld.user.domain.User

interface LoadUserPort {
    fun register(registrationCommand: RegistrationCommand): User
}
