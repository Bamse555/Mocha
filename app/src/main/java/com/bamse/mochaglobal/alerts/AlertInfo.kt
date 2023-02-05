package com.bamse.mochaglobal.alerts

data class AlertInfo(
    val alertsData: Map<Int, List<AlertData>>,
    val currentAlertData: AlertData?,
)
