package com.example.practicekotlin.user.repository

import com.example.practicekotlin.user.entity.UserEntity
import com.example.practicekotlin.user.service.UserRepository
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(
    private val jpaUserRepository: JpaUserRepository
) : UserRepository {

    override fun create(user: UserEntity) {
        jpaUserRepository.save(user)
    }

    override fun getUser(loginId: String): UserEntity {
        return jpaUserRepository.findByLoginId(loginId) ?: fail()
    }
}
