package com.example.chariotkmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform