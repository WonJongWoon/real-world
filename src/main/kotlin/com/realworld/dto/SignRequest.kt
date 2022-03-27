package com.realworld.dto

import com.fasterxml.jackson.annotation.JsonRootName

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
