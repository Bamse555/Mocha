package com.bamse.mochaglobal.ui

import com.bamse.mochaglobal.weatherAlerts.AlertInfo

data class AlertState(
    val alertInfo: AlertInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
