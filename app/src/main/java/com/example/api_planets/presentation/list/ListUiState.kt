package com.example.api_planets.presentation.list

import com.example.api_planets.domain.model.Character

data class ListUiState(
    val isLoading: Boolean = false,
    val characters: List<Character> = emptyList(),
    val error: String? = null,
    val filterName: String = "",
    val filterGender: String = "",
    val filterRace: String = ""
)

data class DetailUiState(
    val isLoading: Boolean = false,
    val character: Character? = null,
    val error: String? = null
)
