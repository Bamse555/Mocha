package com.bamse.mochaglobal.api

import com.squareup.moshi.Json
import java.time.LocalDateTime


data class WeatherAlertDataApi(
    @field:Json(name = "sent")
    val sent: List<String>,
    @field:Json(name = "event")
    val eventsNames: List<String>,
    @field:Json(name = "effective")
    val startDates: List<LocalDateTime>,
    @field:Json(name = "ends")
    val endDates: List<LocalDateTime>,
    @field:Json(name = "senderName")
    val sourcesNames: List<String>,
)