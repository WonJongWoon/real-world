package com.realworld.user.application.port.`in`

data class RegistrationCommand(
    val username: String,
    val email: String,
    val password: String
)
