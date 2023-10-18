package com.example.practicekotlin.user.controller

import com.example.practicekotlin.user.dto.LoginRequest
import com.example.practicekotlin.user.dto.SignupRequest
import com.example.practicekotlin.user.entity.UserEntity
import com.example.practicekotlin.user.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class UserController(
    private val userService: UserService,
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    fun signup(
        @Valid @RequestBody
        request: SignupRequest,
    ): Long {
        return userService.signup(request)
    }

    @PostMapping("/login")
    fun login(
        @Valid @RequestBody
        request: LoginRequest,
    ) {
        userService.login(request)
    }

    @GetMapping("/users")
    fun getUsers(): List<UserEntity> {
        return userService.getUsers()
    }

    @GetMapping("/users/{userId}")
    fun getUsers(@PathVariable userId: Long) {
        userService.getUsers(userId)
    }

    @GetMapping("/health")
    fun health(): String {
        return "health"
    }
}
