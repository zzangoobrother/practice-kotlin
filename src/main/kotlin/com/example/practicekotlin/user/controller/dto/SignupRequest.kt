package com.example.practicekotlin.user.controller.dto

data class SignupRequest(
    val loginId: String,
    val password: String
) {
}