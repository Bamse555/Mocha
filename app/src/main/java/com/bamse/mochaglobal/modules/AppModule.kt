package com.bamse.mochaglobal.modules

import com.bamse.mochaglobal.api.AlertsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAlertApi(): AlertsApi {
        val  httpclient: OkHttpClient.Builder = OkHttpClient.Builder()

//        val logging = HttpLoggingInterceptor()
//        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
//        httpclient.interceptors().add(logging)

        return Retrofit.Builder()
            .baseUrl("https://api.weather.gov/")
            .client(httpclient.build())
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create().asLenient())
            .build()
            .create()
    }
}