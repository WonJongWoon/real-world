package com.realworld.token

import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.MalformedJwtException
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.UnsupportedJwtException
import io.jsonwebtoken.security.Keys
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.nio.charset.StandardCharsets
import java.security.SignatureException
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Date

@Component
class TokenProvider(private val tokenProperties: TokenProperties) {

    private val log = LoggerFactory.getLogger(TokenProvider::class.java)
    private val SIGN_KEY = Keys.hmacShaKeyFor(tokenProperties.secretKey.toByteArray(StandardCharsets.UTF_8))

    fun createToken(username: String): String {
        val now = LocalDateTime.now()
        val issuedAt = Date.from(now.atZone(SEOUL_ZONE_ID).toInstant())
        val expiredAt = Date.from(
            now.plusSeconds(tokenProperties.expirationPeriod)
                .atZone(SEOUL_ZONE_ID)
                .toInstant()
        )

        return Jwts.builder()
            .setHeaderParam(TYPE, TOKEN_TYPE)
            .setSubject(username)
            .setIssuedAt(issuedAt)
            .setExpiration(expiredAt)
            .signWith(SIGN_KEY, SignatureAlgorithm.HS512)
            .compact()
    }

    fun validate(token: String): Boolean = try {
        Jwts.parserBuilder()
            .setSigningKey(SIGN_KEY)
            .build()
            .parseClaimsJwt(token)
        true
    } catch (e: Exception) {
        when (e) {
            is SignatureException -> log.error("Invalid JWT Signature")
            is MalformedJwtException -> log.error("Invalid JWT Token")
            is ExpiredJwtException -> log.error("Expired JWT Token")
            is UnsupportedJwtException -> log.error("UnSupported JWT Token")
            is IllegalArgumentException -> log.error("JWT Claims string is empty.")
        }
        false
    }

    companion object {
        const val TYPE = "typ"
        const val TOKEN_TYPE = "JWT"
        val SEOUL_ZONE_ID: ZoneId = ZoneId.of("Asia/Seoul")
    }
}
