package com.bamse.mochaglobal.util

import com.bamse.mochaglobal.api.Alert
import com.bamse.mochaglobal.weatherAlerts.AlertData
import com.bamse.mochaglobal.weatherAlerts.AlertInfo

private data class IndexedAlertsData(
    val index: Int,
    val data: AlertData
)

fun Alert.toWeatherAlertInfo(): AlertInfo {
    val emptyList = arrayListOf<AlertInfo>()
    val list = weatherData.mapIndexed { index, feature ->
        val eventName = feature.properties.eventName
        val startDate = feature.properties.startDates
        val endDate = feature.properties.endDates
        val sourceName = feature.properties.sourcesNames
        IndexedAlertsData(
            index = index,
            data = AlertData(
                sent = "",//LocalDateTime.parse(feature.properties.sent).toString(),
                eventName = eventName,
                startDate = startDate,
                endDate = endDate,
                sourceName = sourceName
            )
        )
    }.groupBy {
        it.index / 24
    }.mapValues {
        it.value.map { it.data }
    }

    return AlertInfo(alertsDataPerDay = list, currentAlertData = null)
}


