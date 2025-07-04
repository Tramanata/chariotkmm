package com.chariot.backend.model

import jakarta.persistence.*

@Entity
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val user_id: Long = 0,
    val name: String,
    val email: String
)
