package com.example.api_planets.presentation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {
    @Serializable
    data object List : Screen()

    @Serializable
    data class Detail(val id: Int) : Screen()
}
