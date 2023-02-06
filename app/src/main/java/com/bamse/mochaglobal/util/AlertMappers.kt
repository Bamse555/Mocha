package com.bamse.mochaglobal.util

import com.bamse.mochaglobal.api.Alert
import com.bamse.mochaglobal.alerts.AlertData
import com.bamse.mochaglobal.alerts.AlertInfo
import org.joda.time.Period
import java.time.OffsetDateTime
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import kotlin.math.absoluteValue

private data class IndexedAlertsData(
    val index: Int,
    val data: AlertData
)

fun Alert.toAlertInfo(): AlertInfo {
    val list = alertData.mapIndexed { index, feature ->
        val formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm")
        val eventName = feature.properties.eventName
        val startDate = OffsetDateTime.parse(feature.properties.startDate).toZonedDateTime()
        val endDate =
            if (feature.properties.endDate.isNullOrBlank()) null else OffsetDateTime.parse(feature.properties.endDate)
                .toZonedDateTime()
        val duration = if (endDate != null) (Period(
            endDate.toInstant().toEpochMilli(),
            startDate.toInstant().toEpochMilli()
        )) else null
        val sourceName = feature.properties.sourcesName
        val dateTime: ZonedDateTime =
            OffsetDateTime.parse(feature.properties.sent).toZonedDateTime()

        IndexedAlertsData(
            index = index,
            data = AlertData(
                id = feature.properties.id,
                sent = dateTime.format(formatter),
                eventName = eventName,
                startDate = startDate.format(formatter),
                endDate = endDate?.format(formatter),
                duration = if (duration != null) {
                    "${
                        (duration.days).absoluteValue.toString().padStart(2, '0')
                    }D:${duration.hours.absoluteValue.toString().padStart(2, '0')}H:" +
                            "${
                                duration.minutes.absoluteValue.toString().padStart(2, '0')
                            }m"
                } else null,
                sourceName = sourceName,
            )
        )
    }.groupBy {
        it.index / 500
    }.mapValues {
        it.value.map { it.data }
    }

    return AlertInfo(alertsData = list, currentAlertData = null)
}


