package com.example.practicekotlin.user.service

import com.example.practicekotlin.user.entity.UserEntity

interface UserRepository {
    fun create(user: UserEntity): UserEntity

    fun getUser(loginId: String): UserEntity

    fun getUser(id: Long): UserEntity

    fun getUsers(): List<UserEntity>
}
