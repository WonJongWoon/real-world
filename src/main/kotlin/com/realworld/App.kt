package com.realworld

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class RealWorldApplication

fun main(args: Array<String>) {
    runApplication<RealWorldApplication>(*args)
}
