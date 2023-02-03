package com.bamse.mochaglobal.weatherAlerts

data class AlertData(
    val sent: String,
    val eventName: String,
    val startDate: String,
    val endDate: String?,
    val sourceName: String,
)
