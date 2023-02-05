package com.bamse.mochaglobal.alerts

data class AlertData(
    val sent: String,
    val eventName: String,
    val startDate: String,
    val endDate: String?,
    val duration: String?,
    val sourceName: String,
)
