package com.bamse.mochaglobal.ui

import com.bamse.mochaglobal.alerts.AlertInfo

data class AlertState(
    val alertInfo: AlertInfo? = null,
    val alertImages: ArrayList<String>? = arrayListOf(),
    val isLoading: Boolean = false,
    val error: String? = null
)
