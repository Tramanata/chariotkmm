package com.chariot.backend.model

import jakarta.persistence.*

@Entity
@Table(name = "rides")
data class Rider(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    val pickup: String,

    val destination: String
)
