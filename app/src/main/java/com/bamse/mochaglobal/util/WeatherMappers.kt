package com.bamse.mochaglobal.util

import com.bamse.mochaglobal.api.WeatherAlertDataApi
import com.bamse.mochaglobal.api.Alert
import com.bamse.mochaglobal.weatherAlerts.WeatherAlertData
import com.bamse.mochaglobal.weatherAlerts.WeatherAlertInfo
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private data class IndexedAlertsData(
    val index: Int,
    val data: WeatherAlertData
)
fun WeatherAlertDataApi.toWeatherAlertsDataMap(): Map<Int, List<WeatherAlertData>> {
    return sent.mapIndexed { index, time ->
        val eventName = eventsNames[index]
        val startDate = startDates[index]
        val endDate = endDates[index]
        val sourceName = sourcesNames[index]
        IndexedAlertsData(
            index = index,
            data = WeatherAlertData(
                sent = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
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
}

fun Alert.toWeatherAlertInfo(): List<WeatherAlertInfo> {
    val list = arrayListOf<WeatherAlertInfo>()
    weatherData.forEach {
        val weatherDataMap = it.toWeatherAlertsDataMap()
        val now = LocalDateTime.now()
        val currentWeatherData = weatherDataMap[0]?.find {
            val hour = if (now.minute < 30) now.hour else now.hour + 1
            it.sent.hour == hour
        }
        val element = WeatherAlertInfo(
            alertsDataPerDay = weatherDataMap,
            currentAlertData = currentWeatherData
        )
        list.add(element)
    }
    return list.toList()
}


