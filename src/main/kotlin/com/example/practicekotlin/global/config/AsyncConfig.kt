package com.example.practicekotlin.global.config

import com.example.practicekotlin.global.decorator.LoggingTaskDecorator
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.task.TaskExecutor
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor

@Configuration
class AsyncConfig {

    @Bean
    fun taskExecutor(): TaskExecutor {
        val taskExecutor = ThreadPoolTaskExecutor()
        taskExecutor.corePoolSize = 10
        taskExecutor.queueCapacity = 20
        taskExecutor.maxPoolSize = 30
        taskExecutor.setTaskDecorator(LoggingTaskDecorator())

        return taskExecutor
    }
}
