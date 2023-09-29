package com.example.practicekotlin.user.service

import com.example.practicekotlin.user.dto.LoginRequest
import com.example.practicekotlin.user.dto.SignupRequest
import com.example.practicekotlin.user.entity.UserEntity
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun signup(request: SignupRequest) {
        val user = UserEntity(request.loginId, request.password)
        userRepository.create(user);
    }

    fun login(request: LoginRequest) {
        TODO("Not yet implemented")
    }
}