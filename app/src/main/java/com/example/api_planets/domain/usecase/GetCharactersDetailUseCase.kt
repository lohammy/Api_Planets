package com.example.api_planets.domain.usecase

import com.example.api_planets.domain.repository.CharacterRepository
import javax.inject.Inject

class GetCharactersDetailUseCase @Inject constructor(
    private val repository: CharacterRepository
){
    operator fun invoke(id: Int) = repository.getCharacterDetail(id)
}
