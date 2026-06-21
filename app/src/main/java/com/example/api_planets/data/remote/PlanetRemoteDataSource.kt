package com.example.api_planets.data.remote

import com.example.api_planets.data.remote.dto.PlanetDto
import com.example.api_planets.data.remote.dto.PlanetResponseDto

interface PlanetRemoteDataSource {
    suspend fun getPlanets(page: Int, limit: Int, name: String?): Result<PlanetResponseDto>
    suspend fun getPlanetDetail(id: Int): Result<PlanetDto>
}
