package com.bamse.mochaglobal.util

import com.bamse.mochaglobal.weatherAlerts.WeatherAlertInfo

sealed class Resource<T>(val data: Any? = null, val message: String? = null) {
    class Success<T>(data: WeatherAlertInfo): Resource<T>(data)
    class Error<T>(message: String, data: T? = null): Resource<T>(data, message)
}
