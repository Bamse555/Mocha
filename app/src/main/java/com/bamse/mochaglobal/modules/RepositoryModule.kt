package com.plcoding.weatherapp.di

import com.bamse.mochaglobal.repository.WeatherAlertsRepository
import com.bamse.mochaglobal.repository.WeatherAlertsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindWeatherRepository(
        weatherRepositoryImpl: WeatherAlertsRepositoryImpl
    ): WeatherAlertsRepository
}