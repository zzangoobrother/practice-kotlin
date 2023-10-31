package com.example.practicekotlin.user.controller

import com.example.practicekotlin.user.dto.LoginRequest
import com.example.practicekotlin.user.dto.SignupRequest
import com.example.practicekotlin.user.entity.UserEntity
import com.example.practicekotlin.user.service.UserService
import org.slf4j.LoggerFactory
import org.slf4j.MDC
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

    private val log = LoggerFactory.getLogger(UserController::class.java)

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    fun signup(
        @Valid @RequestBody
        request: SignupRequest,
    ): UserEntity {
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

    @GetMapping("/async")
    fun asyncTest(): String {
        var i: Int = 0
        for (i: Int in 0..120) {
            log.info("=========")
            MDC.put("a", i.toString())
            log.info(MDC.get("a"))
            userService.asyncTest(i)
            log.info("============")
        }

        return "end"
    }

    @GetMapping("/logs")
    fun logs() {
        MDC.put("job", "dev")
        log.trace("signup trace")
        log.debug("signup debug")
        log.info("signup info")
        log.warn("signup warn")
        log.error("signup error")
        MDC.clear()
    }
}
