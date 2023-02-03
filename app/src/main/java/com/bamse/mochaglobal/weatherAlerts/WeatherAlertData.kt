package com.bamse.mochaglobal.weatherAlerts

import java.time.LocalDateTime

data class WeatherAlertData(
    val sent: LocalDateTime,
    val eventName: String,
    val startDate: LocalDateTime,
    val endDate: LocalDateTime,
    val sourceName: String,
)
