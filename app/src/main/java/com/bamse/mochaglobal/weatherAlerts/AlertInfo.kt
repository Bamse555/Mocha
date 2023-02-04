package com.bamse.mochaglobal.weatherAlerts

data class AlertInfo(
    val alertsData: Map<Int, List<AlertData>>,
    val currentAlertData: AlertData?
)
