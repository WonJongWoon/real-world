package com.realworld.dto

import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.fasterxml.jackson.annotation.JsonTypeName

@JsonTypeName("profile")
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
data class ProfileResponse(
    val userName: String,
    val bio: String,
    val image: String?,
    val following: Boolean
)
