package com.example.practicekotlin.user.service

import com.example.practicekotlin.user.dto.LoginRequest
import com.example.practicekotlin.user.dto.SignupRequest
import com.example.practicekotlin.user.entity.UserEntity
import org.slf4j.LoggerFactory
import org.slf4j.MDC
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {

    private val log = LoggerFactory.getLogger(UserService::class.java)

    fun signup(request: SignupRequest): UserEntity {
        val user = UserEntity(request.loginId, request.password)
        return requireNotNull(userRepository.create(user))
    }

    fun login(request: LoginRequest) {
        val userEntity = userRepository.getUser(request.loginId)

        if (!userEntity.password.equals(request.password)) {
            throw IllegalArgumentException("비밀번호가 틀립니다.")
        }
    }

    fun getUsers(): List<UserEntity> {
        return userRepository.getUsers()
    }

    fun getUsers(userId: Long): UserEntity {
        return userRepository.getUser(userId)
    }

    @Async
    fun asyncTest(i: Int) {
        log.info(MDC.get("a") + ":" + i)
    }
}
