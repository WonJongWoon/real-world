package com.realworld.dto

import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.fasterxml.jackson.annotation.JsonTypeName

@JsonTypeName("user")
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
sealed class SignRequest {
    data class In(
        val email: String,
        val password: String,
    )

    data class Up(
        val username: String,
        val email: String,
        val password: String
    )
}
