package com.realworld.dto

data class AuthorResponse(
    val username: String,
    val bio: String,
    val image: String?,
    val following: Boolean
)
