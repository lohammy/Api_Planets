package com.example.api_planets.data.remote.remotedatasource

import com.example.api_planets.data.remote.DragonBallApi
import com.example.api_planets.data.remote.PlanetRemoteDataSource
import com.example.api_planets.data.remote.dto.PlanetDto
import com.example.api_planets.data.remote.dto.PlanetResponseDto
import jakarta.inject.Inject

class PlanetRemoteDataSourceImpl @Inject constructor(
    private val api: DragonBallApi
) : PlanetRemoteDataSource {

    override suspend fun getPlanets(page: Int, limit: Int, name: String?): Result<PlanetResponseDto> {
        return try {
            val response = api.getPlanets(page, limit, name)
            if (response.isSuccessful) {
                Result.success(response.body()!!)
            } else {
                Result.failure(Exception(response.message()))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getPlanetDetail(id: Int): Result<PlanetDto> {
        return try {
            val response = api.getPlanetDetail(id)
            if (response.isSuccessful) {
                Result.success(response.body()!!)
            } else {
                Result.failure(Exception(response.message()))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
