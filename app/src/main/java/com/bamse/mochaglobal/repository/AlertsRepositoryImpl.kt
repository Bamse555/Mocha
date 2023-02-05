package com.bamse.mochaglobal.repository

import com.bamse.mochaglobal.util.ApiResponse
import com.bamse.mochaglobal.alerts.AlertInfo
import com.bamse.mochaglobal.api.AlertsApi
import com.bamse.mochaglobal.util.toAlertInfo
import retrofit2.Call
//import com.bamse.mochaglobal.alerts.AlertImage
import javax.inject.Inject

class AlertsRepositoryImpl @Inject constructor(
    private val api: AlertsApi
) : AlertsRepository {

    override suspend fun getAlertsData(): ApiResponse<AlertInfo> {
        return try {
            val alerts = api.getAlertsData().toAlertInfo()
            ApiResponse.Success(data = alerts)
        } catch (exception: Exception) {
            ApiResponse.Error(message = "An error occurred ${exception.message.toString()}")
        }
    }

    override suspend fun getImages(): Call<String>? {
        return try {
                api.getImages()
        } catch (exception: Exception) {
            return null
        }
    }
}