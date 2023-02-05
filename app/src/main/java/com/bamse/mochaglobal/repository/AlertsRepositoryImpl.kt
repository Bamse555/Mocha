package com.bamse.mochaglobal.repository

import com.bamse.mochaglobal.api.Alert
import com.bamse.mochaglobal.util.Resource
import com.bamse.mochaglobal.weatherAlerts.AlertInfo
import com.bamse.mochaglobal.api.AlertsApi
import com.bamse.mochaglobal.util.toWeatherAlertInfo
import retrofit2.Call
//import com.bamse.mochaglobal.weatherAlerts.AlertImage
import javax.inject.Inject

class AlertsRepositoryImpl @Inject constructor(
    private val api: AlertsApi
) : AlertsRepository {

    override suspend fun getAlertsData(): Resource<AlertInfo> {
        return try {
            val alerts = api.getAlertsData().toWeatherAlertInfo()
            Resource.Success(data = alerts)
        } catch (exception: Exception) {
            Resource.Error(message = "An error occurred ${exception.message.toString()}")
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