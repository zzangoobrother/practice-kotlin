package com.example.practicekotlin.global.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    protected fun handleMethodArgumentNotValidException(
        e: MethodArgumentNotValidException
    ): ResponseEntity<ErrorResponse> {
        val fieldErrors = e.bindingResult.getFieldErrors()
        val result = fieldErrors.stream()
            .map { error ->
                FieldError(
                    error.field,
                    error.rejectedValue.toString(),
                    error.defaultMessage.toString()
                )
            }.toList()

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(ErrorResponse(
                message = "유효한 입력값이 아닙니다.",
                status = 400,
                errors = result,
                code = "C001"
            ))
    }
}