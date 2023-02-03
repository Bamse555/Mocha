package com.bamse.mochaglobal.util

import com.bamse.mochaglobal.api.AlertProperties
import com.bamse.mochaglobal.api.Alert
import com.bamse.mochaglobal.weatherAlerts.WeatherAlertData
import com.bamse.mochaglobal.weatherAlerts.WeatherAlertInfo
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private data class IndexedAlertsData(
    val index: Int,
    val data: WeatherAlertData
)

fun Alert.toWeatherAlertInfo(): WeatherAlertInfo {
    val emptyList = arrayListOf<WeatherAlertInfo>()
    val list = weatherData.mapIndexed { index, feature ->
        val eventName = feature.properties.eventName
        val startDate = feature.properties.startDates
        val endDate = feature.properties.endDates
        val sourceName = feature.properties.sourcesNames
        IndexedAlertsData(
            index = index,
            data = WeatherAlertData(
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

    return WeatherAlertInfo(alertsDataPerDay = list, currentAlertData = null)
}


