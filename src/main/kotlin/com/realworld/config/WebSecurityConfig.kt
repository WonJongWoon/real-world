package com.realworld.config

import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.config.web.servlet.invoke

@EnableWebSecurity
class WebSecurityConfig : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity?) {
        http?.invoke {
            cors { disable() }
            httpBasic { disable() }
            csrf { disable() }
            headers { frameOptions { disable() } }
            sessionManagement {
                sessionCreationPolicy = SessionCreationPolicy.STATELESS
            }
        }
    }
}
