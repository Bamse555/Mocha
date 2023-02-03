package com.bamse.mochaglobal.api

import com.bamse.mochaglobal.weatherAlerts.WeatherAlertInfo
import com.squareup.moshi.Json
import java.time.LocalDateTime

data class Alert(
    @field:Json(name = "features")
    val weatherData: List<WeatherAlertDataApi>
)
