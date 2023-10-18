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
    fun `회원가입을 한다`() {
        val response: ExtractableResponse<Response> = MemberSteps.회원가입(LOGINID, PASSWORD)

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value())
    }

    @Test
    fun `로그인을 한다`() {
        MemberSteps.회원가입(LOGINID, PASSWORD)

        val response: ExtractableResponse<Response> = MemberSteps.로그인(LOGINID, PASSWORD)

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value())
    }

    @Test
    fun `회원 다건 조회를 한다`() {
        MemberSteps.회원가입(LOGINID, PASSWORD)

        val response: ExtractableResponse<Response> = MemberSteps.`회원 다건 조회`()

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value())
    }

//    @Test
//    fun `회원 단건 조회를 한다`() {
//        val userId = MemberSteps.회원가입(LOGINID, PASSWORD).jsonPath().getLong("userId")
//
//        val response: ExtractableResponse<Response> = MemberSteps.`회원 단건 조회`(userId)
//
//        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value())
//    }
}
