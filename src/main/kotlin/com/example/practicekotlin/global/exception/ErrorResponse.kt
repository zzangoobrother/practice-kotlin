package com.example.practicekotlin.global.exception

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
class ErrorResponse(
    private val message: String,
    private val status: Int,
    private val errors: List<FieldError>,
    private val code: String
) {
}

class FieldError(
    private val field: String,
    private val value: String,
    private val reason: String
) {

}
