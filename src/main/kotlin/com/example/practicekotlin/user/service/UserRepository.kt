package com.example.practicekotlin.user.service

import com.example.practicekotlin.user.entity.UserEntity

interface UserRepository {
    fun create(user: UserEntity)
}