package com.example.practicekotlin.user.dto

data class SignupRequest(
    val loginId: String,
    val password: String
) {
}