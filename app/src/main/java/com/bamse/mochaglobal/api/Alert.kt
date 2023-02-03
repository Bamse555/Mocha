package com.bamse.mochaglobal.api

import com.squareup.moshi.Json

data class Alert(
    @field:Json(name = "features")
    val weatherData: List<AlertFeatures>
)
