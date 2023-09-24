package com.example.practicekotlin.user.dto

import javax.validation.constraints.NotBlank

data class SignupRequest(
    @field: NotBlank
    val loginId: String,

    @field: NotBlank
    val password: String
) {
}