package com.bamse.mochaglobal.repository

import com.bamse.mochaglobal.util.Resource
import com.bamse.mochaglobal.weatherAlerts.WeatherAlertInfo

interface WeatherAlertsRepository {
    suspend fun getWeatherAlertsData(): Resource<WeatherAlertInfo>
}