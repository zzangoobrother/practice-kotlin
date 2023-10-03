package com.example.practicekotlin.user.service

import com.example.practicekotlin.user.dto.LoginRequest
import com.example.practicekotlin.user.dto.SignupRequest
import com.example.practicekotlin.user.repository.FakeUserRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class UserServiceTest {
    private lateinit var userRepository: UserRepository
    private lateinit var userService: UserService

    @BeforeEach
    fun setup() {
        userRepository = FakeUserRepository()
        userService = UserService(userRepository)
    }

    @Test
    fun `회원가입`() {
        val request = SignupRequest("abcd", "1234")
        userService.signup(request)
    }

    @Test
    fun `로그인`() {
        val signupRequest = SignupRequest("abcd", "1234")
        userService.signup(signupRequest)

        val request = LoginRequest("abcd", "1234")
        userService.login(request)
    }
}
