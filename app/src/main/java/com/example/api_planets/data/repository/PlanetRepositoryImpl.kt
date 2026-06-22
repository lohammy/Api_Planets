package com.example.api_planets.data.repository

import com.example.api_planets.data.remote.PlanetRemoteDataSource
import com.example.api_planets.data.remote.Resource
import com.example.api_planets.domain.model.Planet
import com.example.api_planets.domain.repository.PlanetRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PlanetRepositoryImpl @Inject constructor(
    private val remoteDataSource: PlanetRemoteDataSource,
) : PlanetRepository {

    override fun getPlanets(
        page: Int,
        limit: Int,
        name: String?,
    ): Flow<Resource<List<Planet>>> = flow {

        emit(Resource.Loading())

        val response = remoteDataSource.getPlanets(page, limit, name)
        response.onSuccess { planets ->
            emit(Resource.Success(planets.items.map { it.toDomain() }))
        }.onFailure {
            emit(Resource.Error(it.message ?: "Error desconocido"))
        }
    }

    override fun getPlanetDetail(id: Int): Flow<Resource<Planet>> = flow {
        emit(Resource.Loading())

        val response = remoteDataSource.getPlanetDetail(id)
        response.onSuccess { planet ->
            emit(Resource.Success(planet.toDomain() ))
        }.onFailure {
            emit(Resource.Error(it.message ?: "Error desconocido"))
        }
    }
}
