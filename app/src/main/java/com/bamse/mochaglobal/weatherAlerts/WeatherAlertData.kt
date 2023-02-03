package com.bamse.mochaglobal.weatherAlerts

import java.time.LocalDateTime

data class WeatherAlertData(
    val sent: String,
    val eventName: String,
    val startDate: String,
    val endDate: String?,
    val sourceName: String,
)
