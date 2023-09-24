package com.example.practicekotlin.user.entity

import javax.persistence.*

@Entity
@Table(name = "users")
class UserEntity(

    @Column(name = "loginId", unique = true, nullable = false)
    val loginId: String,

    @Column(name = "password", nullable = false)
    val password: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
) {
}