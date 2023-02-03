package com.bamse.mochaglobal.api

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAlertsApi {

    @GET("alerts/active?status=actual&message_type=alert")
    suspend fun getWeatherAlertsData(
//        @Query("latitude") lat: Double,
//        @Query("longitude") long: Double
    ): Alert
}