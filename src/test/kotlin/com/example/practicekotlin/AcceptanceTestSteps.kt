package com.example.practicekotlin

import io.restassured.RestAssured
import io.restassured.specification.RequestSpecification

open class AcceptanceTestSteps {

    companion object {
        fun given(): RequestSpecification {
            return RestAssured
                .given().log().all()
        }
    }
}