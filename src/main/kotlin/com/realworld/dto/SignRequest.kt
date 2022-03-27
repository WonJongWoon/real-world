package com.realworld.dto

import com.fasterxml.jackson.annotation.JsonRootName
import com.realworld.user.User
import org.apache.logging.log4j.util.Strings

sealed class SignRequest {
    @JsonRootName("user")
    data class In(
        val email: String,
        val password: String,
    )

    @JsonRootName("user")
    data class Up(
        val username: String,
        val email: String,
        val password: String
    )
}

fun SignRequest.Up.toEntity() = User(
    email = this.email,
    username = this.username,
    password = password,
    bio = Strings.EMPTY,
    image = null
)
