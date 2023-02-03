package com.bamse.mochaglobal.util

import com.bamse.mochaglobal.weatherAlerts.AlertInfo

sealed class Resource<T>(val data: Any? = null, val message: String? = null) {
    class Success<T>(data: AlertInfo): Resource<T>(data)
    class Error<T>(message: String, data: T? = null): Resource<T>(data, message)
}
