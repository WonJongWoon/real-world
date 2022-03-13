package com.realworld.user.adapter.`in`.web

import com.realworld.user.application.port.`in`.RegistrationCommand
import com.realworld.user.application.port.`in`.UserManagementUseCase
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(
    path = ["/api"],
    produces = [MediaType.APPLICATION_JSON_VALUE],
    consumes = [MediaType.APPLICATION_JSON_VALUE]
)
class UserManagementController(
    private val userManagementUseCase: UserManagementUseCase
) {

    @PostMapping(path = ["/users"])
    fun register(@RequestBody registrationCommand: RegistrationCommand) {
        userManagementUseCase.register(registrationCommand)
    }
}
