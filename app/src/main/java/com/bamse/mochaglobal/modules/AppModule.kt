package com.bamse.mochaglobal.modules

import android.app.Application
import com.bamse.mochaglobal.api.AlertsApi
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideWeatherApi(): AlertsApi {
        val logging: HttpLoggingInterceptor? = HttpLoggingInterceptor()
        val  httpclient: OkHttpClient.Builder? = OkHttpClient.Builder()
        logging?.setLevel(HttpLoggingInterceptor.Level.BODY)
        if (logging != null) {
            httpclient?.interceptors()?.add(logging)
        }
        return Retrofit.Builder()
            .baseUrl("https://api.weather.gov/")
            .client(httpclient!!.build())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideFusedLocationProviderClient(app: Application): FusedLocationProviderClient {
        return LocationServices.getFusedLocationProviderClient(app)
    }
}