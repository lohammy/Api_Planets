package com.example.api_planets.domain.repository

import com.example.api_planets.data.remote.Resource
import com.example.api_planets.domain.model.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun getCharacters(
        page: Int,
        limit: Int,
        name: String?,
        gender: String?,
        race: String?,
    ): Flow<Resource<List<Character>>>

    fun getCharacterDetail(id: Int): Flow<Resource<Character>>
}
