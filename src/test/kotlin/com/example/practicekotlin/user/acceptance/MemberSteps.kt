package com.example.practicekotlin.user.acceptance

import com.example.practicekotlin.AcceptanceTestSteps
import io.restassured.response.ExtractableResponse
import io.restassured.response.Response
import org.springframework.http.MediaType

class MemberSteps : AcceptanceTestSteps() {

    companion object {
        fun `회원가입`(loginId: String, password: String): ExtractableResponse<Response> {
            val params: MutableMap<String, String> = mutableMapOf()
            params.put("loginId", loginId)
            params.put("password", password)

            return given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(params)
                .`when`().post("/signup")
                .then().log().all().extract()
        }

        fun `로그인`(loginId: String, password: String): ExtractableResponse<Response> {
            val params: MutableMap<String, String> = mutableMapOf()
            params.put("loginId", loginId)
            params.put("password", password)

            return given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(params)
                .`when`().post("/login")
                .then().log().all().extract()
        }
    }
}