package com.bamse.mochaglobal.api

import retrofit2.http.GET

interface AlertsApi {

    @GET("alerts/active?status=actual&message_type=alert")
    suspend fun getAlertsData(
//        @Query("latitude") lat: Double,
//        @Query("longitude") long: Double
    ): Alert
}