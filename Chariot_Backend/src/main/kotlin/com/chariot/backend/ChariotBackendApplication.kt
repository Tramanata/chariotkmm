package com.chariot.backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ChariotBackendApplication

fun main(args: Array<String>) {
	runApplication<ChariotBackendApplication>(*args)
}
