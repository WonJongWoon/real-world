package com.realworld.dto

data class AuthorResponse(
    val userName: String,
    val bio: String,
    val image: String?,
    val following: Boolean
)
