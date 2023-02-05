package com.bamse.mochaglobal.repository

import com.bamse.mochaglobal.util.ApiResponse
import com.bamse.mochaglobal.alerts.AlertInfo
import retrofit2.Call

interface AlertsRepository {
    suspend fun getAlertsData(): ApiResponse<AlertInfo>

    suspend fun getImages(): Call<String>?
}