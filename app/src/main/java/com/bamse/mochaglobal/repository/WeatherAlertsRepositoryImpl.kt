package com.bamse.mochaglobal.repository

import com.bamse.mochaglobal.util.Resource
import com.bamse.mochaglobal.weatherAlerts.WeatherAlertInfo
import com.bamse.mochaglobal.api.WeatherAlertsApi
import com.bamse.mochaglobal.util.toWeatherAlertInfo
import javax.inject.Inject

class WeatherAlertsRepositoryImpl @Inject constructor(
    private val api: WeatherAlertsApi
): WeatherAlertsRepository {

    override suspend fun getWeatherAlertsData(): Resource<WeatherAlertInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherAlertsData().toWeatherAlertInfo()
            )
        } catch(e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}