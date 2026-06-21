package com.example.api_planets.di

import com.example.api_planets.data.remote.DragonBallApi
import com.example.api_planets.data.remote.PlanetRemoteDataSource
import com.example.api_planets.data.remote.remotedatasource.PlanetRemoteDataSourceImpl
import com.example.api_planets.data.repository.CharacterRepositoryImpl
import com.example.api_planets.data.repository.PlanetRepositoryImpl
import com.example.api_planets.domain.repository.CharacterRepository
import com.example.api_planets.domain.repository.PlanetRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideMoshi(): Moshi {
        return Moshi
            .Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun provideApi(moshi: Moshi): DragonBallApi {
        return Retrofit.Builder()
            .baseUrl("https://dragonball-api.com/api/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(DragonBallApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCharacterRepository(api: DragonBallApi): CharacterRepository {
        return CharacterRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun providePlanetRemoteDataSource(api: DragonBallApi): PlanetRemoteDataSource {
        return PlanetRemoteDataSourceImpl(api)
    }

    @Provides
    @Singleton
    fun providePlanetRepository(remoteDataSource: PlanetRemoteDataSource): PlanetRepository {
        return PlanetRepositoryImpl(remoteDataSource)
    }
}
