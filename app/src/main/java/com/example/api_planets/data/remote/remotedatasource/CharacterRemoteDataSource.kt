package com.example.api_planets.data.remote.remotedatasource

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.api_planets.data.remote.dto.CharacterResponseDto
import com.example.api_planets.data.remote.DragonBallApi
import com.example.api_planets.data.remote.dto.CharacterDto
import jakarta.inject.Inject

class CharacterRemoteDataSource @Inject constructor(
    private val api: DragonBallApi
) {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    suspend fun getCharacters(
        page: Int,
        limit: Int,
        name: String?,
        gender: String?,
        race: String?,
    ): Result<CharacterResponseDto> {
        try {
            val response = api.getCharacters(page, limit, name, gender, race)
            if (!response.isSuccessful) {
                return Result.failure(Exception("Error de red ${response.code()}"))
            }
            return Result.success(response.body()!!)
        } catch (e: HttpException) {
            return Result.failure(Exception("Error de servidor", e))
        } catch (e: Exception) {
            return Result.failure(Exception("Error desconocido", e))
        }
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    suspend fun getCharacterDetail(id: Int): Result<CharacterDto> {
        try {
            val response = api.getCharacterDetail(id)
            if (!response.isSuccessful) {
                return Result.failure(Exception("Error de red ${response.code()}"))
            }
            return Result.success(response.body()!!)
        } catch (e: HttpException) {
            return Result.failure(Exception("Error de servidor", e))
        } catch (e: Exception) {
            return Result.failure(Exception("Error desconocido", e))
        }
    }
}