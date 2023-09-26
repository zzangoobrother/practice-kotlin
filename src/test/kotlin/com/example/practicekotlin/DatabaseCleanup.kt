package com.example.practicekotlin

import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Profile
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Profile("test")
@Service
class DatabaseCleanup : InitializingBean {

    @Autowired
    private lateinit var jdbcTemplate: JdbcTemplate

    private lateinit var tableNames: List<String>

    override fun afterPropertiesSet() {
        tableNames = jdbcTemplate.query("SHOW TABLES", {resultSet, rowNumber -> resultSet.getString(1)})
    }

    @Transactional
    fun execute() {
        jdbcTemplate.execute("SET REFERENTIAL_INTEGRITY FALSE")
        for (tableName in tableNames) {
            jdbcTemplate.execute("TRUNCATE TABLE " + tableName)
        }
        jdbcTemplate.execute("SET REFERENTIAL_INTEGRITY TRUE")
    }
}