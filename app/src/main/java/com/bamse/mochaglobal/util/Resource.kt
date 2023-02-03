package com.bamse.mochaglobal.util

sealed class Resource<T>(val data: Any? = null, val message: String? = null) {
    class Success<T>(data: List<T>?): Resource<T>(data)
    class Error<T>(message: String, data: T? = null): Resource<T>(data, message)
}
