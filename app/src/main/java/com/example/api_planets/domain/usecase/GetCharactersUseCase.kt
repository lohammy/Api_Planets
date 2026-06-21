package com.example.api_planets.domain.usecase

import com.example.api_planets.domain.repository.CharacterRepository
import jakarta.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    operator fun invoke(
        page: Int = 1,
        limit: Int = 10,
        name: String? = null,
        gender: String? = null,
        race: String? = null
    ) = repository.getCharacters(page, limit, name, gender, race)
}