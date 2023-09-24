package com.example.practicekotlin.user.controller

import com.example.practicekotlin.user.dto.SignupRequest
import com.example.practicekotlin.user.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class UserController(
    private val userService: UserService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    fun signup(@Valid @RequestBody request: SignupRequest) {
        userService.signup(request)
    }
}