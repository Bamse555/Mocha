package com.bamse.mochaglobal.weatherAlerts

data class AlertInfo(
    val alertsDataPerDay: Map<Int, List<AlertData>>,
    val currentAlertData: AlertData?
)
