package com.realworld.controller

import com.realworld.dto.SignRequest
import com.realworld.dto.UserResponse
import com.realworld.user.UserSignService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users")
class UserSignController(
    private val userSignService: UserSignService
) {

    @PostMapping
    fun signUp(@RequestBody signUpRequest: SignRequest.Up): UserResponse {
        return userSignService.signUp(signUpRequest)
    }

    @PostMapping("/login")
    fun signIn(@RequestBody signInRequest: SignRequest.In): UserResponse {
        return userSignService.signIn(signInRequest)
    }
}
