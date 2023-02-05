package com.bamse.mochaglobal.modules

import com.bamse.mochaglobal.repository.AlertsRepository
import com.bamse.mochaglobal.repository.AlertsRepositoryImpl
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
    abstract fun bindAlertRepository(
        alertRepositoryImpl: AlertsRepositoryImpl
    ): AlertsRepository
}