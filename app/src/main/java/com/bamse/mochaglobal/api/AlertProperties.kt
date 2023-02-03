package com.bamse.mochaglobal.api

import com.squareup.moshi.Json
import java.time.LocalDateTime

//properties
data class AlertProperties(
    @field:Json(name = "sent")
    val sent: String,
    @field:Json(name = "event")
    val eventName: String,
    @field:Json(name = "effective")
    val startDates: String,
    @field:Json(name = "ends")
    val endDates: String?,
    @field:Json(name = "senderName")
    val sourcesNames: String,
)