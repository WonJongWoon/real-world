package com.realworld.token

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.stereotype.Component

@ConstructorBinding
@ConfigurationProperties(prefix = "jwt")
data class TokenProperties(
    val secretKey: String,
    val expirationPeriod: Long
)
