package com.example.practicekotlin.user.acceptance

import com.example.practicekotlin.AcceptanceTest
import io.restassured.response.ExtractableResponse
import io.restassured.response.Response
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus

class MemberAcceptanceTest : AcceptanceTest() {

    val LOGINID: String = "abcd"
    val PASSWORD: String = "1234"

    @Test
    fun signup() {
        val response: ExtractableResponse<Response> = MemberSteps.회원가입(LOGINID, PASSWORD)

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value())
    }

    @Test
    fun login() {
        MemberSteps.회원가입(LOGINID, PASSWORD)

        val response: ExtractableResponse<Response> = MemberSteps.로그인(LOGINID, PASSWORD)

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value())
    }
}