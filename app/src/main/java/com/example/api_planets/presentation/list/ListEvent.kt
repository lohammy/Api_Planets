package com.example.api_planets.presentation.list

sealed interface ListEvent {

    data class UpdateFilters(
        val name: String,
        val gender: String,
        val race: String
    ) : ListEvent

    data object Search : ListEvent
}