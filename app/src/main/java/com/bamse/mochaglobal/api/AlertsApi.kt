package com.bamse.mochaglobal.api

import retrofit2.Call
import retrofit2.http.GET

interface AlertsApi {

    @GET("alerts/active?status=actual&message_type=alert")
    suspend fun getAlertsData(): Alert

    @GET("https://picsum.photos/1000")
    fun getImages(): Call<String>
}