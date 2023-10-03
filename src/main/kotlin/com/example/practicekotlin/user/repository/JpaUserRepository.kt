package com.example.practicekotlin.user.repository

import com.example.practicekotlin.user.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface JpaUserRepository : JpaRepository<UserEntity, Long> {
    fun findByLoginId(loginId: String): UserEntity?
}
