package com.bamse.mochaglobal.repository

import com.bamse.mochaglobal.util.Resource
import com.bamse.mochaglobal.weatherAlerts.AlertInfo
import com.bamse.mochaglobal.api.AlertsApi
import com.bamse.mochaglobal.util.toWeatherAlertInfo
import javax.inject.Inject

class AlertsRepositoryImpl @Inject constructor(
    private val api: AlertsApi
): AlertsRepository {

    override suspend fun getAlertsData(): Resource<AlertInfo> {
        return try {
            Resource.Success(
                data = api.getAlertsData().toWeatherAlertInfo()
            )
        } catch(e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}