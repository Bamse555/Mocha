package com.bamse.mochaglobal.weatherAlerts

data class WeatherAlertInfo(
    val alertsDataPerDay: Map<Int, List<WeatherAlertData>>,
    val currentAlertData: WeatherAlertData?
)
