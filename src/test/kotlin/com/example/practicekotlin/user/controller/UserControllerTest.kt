package com.example.practicekotlin.user.controller

import com.example.practicekotlin.user.dto.LoginRequest
import com.example.practicekotlin.user.dto.SignupRequest
import com.example.practicekotlin.user.service.UserService
import com.fasterxml.jackson.databind.ObjectMapper
import com.ninjasquad.springmockk.MockkBean
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post

@WebMvcTest(UserController::class)
class UserControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @MockkBean
    private lateinit var userService: UserService

    @Test
    fun `회원가입을 한다`() {
        val request = SignupRequest(
            loginId = "abcd",
            password = "1234",
        )

        every { userService.signup(request) } just Runs

        mockMvc.post("/signup") {
            content = objectMapper.writeValueAsString(request)
            contentType = MediaType.APPLICATION_JSON
        }
            .andDo { print() }
            .andExpect {
                status { isCreated() }
            }
    }

    @Test
    fun `회원가입 중 id를 입력하지 않으면 에러`() {
        val request = SignupRequest(
            loginId = "",
            password = "1234",
        )

        every { userService.signup(request) } just Runs

        mockMvc.post("/signup") {
            content = objectMapper.writeValueAsString(request)
            contentType = MediaType.APPLICATION_JSON
        }
            .andDo { print() }
            .andExpect {
                status { isBadRequest() }
            }
    }

    @Test
    fun `회원가입 중 비밀번호를 입력하지 않으면 에러`() {
        val request = SignupRequest(
            loginId = "abcd",
            password = "",
        )

        every { userService.signup(request) } just Runs

        mockMvc.post("/signup") {
            content = objectMapper.writeValueAsString(request)
            contentType = MediaType.APPLICATION_JSON
        }
            .andDo { print() }
            .andExpect {
                status { isBadRequest() }
            }
    }

    @Test
    fun `로그인을 한다`() {
        val request = LoginRequest(
            loginId = "abcd",
            password = "1234",
        )

        every { userService.login(request) } just Runs

        mockMvc.post("/login") {
            content = objectMapper.writeValueAsString(request)
            contentType = MediaType.APPLICATION_JSON
        }
            .andDo { print() }
            .andExpect {
                status { isOk() }
            }
    }

    @Test
    fun `회원을 다건 조회한다`() {
        every { userService.getUsers() } just Runs

        mockMvc.get("/users") {
            contentType = MediaType.APPLICATION_JSON
        }
            .andDo { print() }
            .andExpect {
                status { isOk() }
            }
    }
}
