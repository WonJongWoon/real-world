package com.realworld.user.application.port.`in`


class RegistrationCommand(val user: RegistrationDto) {
    data class RegistrationDto(
        val username: String,
        val email: String,
        val password: String
    )
}
