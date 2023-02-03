package com.bamse.mochaglobal.api

import com.squareup.moshi.Json

data class AlertFeatures(
    @field:Json(name = "properties")
    val properties: AlertProperties
)