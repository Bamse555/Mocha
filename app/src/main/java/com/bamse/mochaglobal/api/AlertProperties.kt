package com.bamse.mochaglobal.api

import com.squareup.moshi.Json

//properties
data class AlertProperties(
    @field:Json(name = "id")
    val id: String,
    @field:Json(name = "sent")
    val sent: String,
    @field:Json(name = "event")
    val eventName: String,
    @field:Json(name = "effective")
    val startDate: String,
    @field:Json(name = "ends")
    val endDate: String?,
    @field:Json(name = "senderName")
    val sourcesName: String,
)