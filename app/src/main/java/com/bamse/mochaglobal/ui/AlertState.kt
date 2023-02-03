package com.bamse.mochaglobal.ui

import com.bamse.mochaglobal.weatherAlerts.WeatherAlertInfo

data class AlertState(
    val weatherAlertInfo: WeatherAlertInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
