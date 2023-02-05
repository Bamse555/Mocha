package com.bamse.mochaglobal.repository

import com.bamse.mochaglobal.util.Resource
//import com.bamse.mochaglobal.weatherAlerts.AlertImage
import com.bamse.mochaglobal.weatherAlerts.AlertInfo
import retrofit2.Call

interface AlertsRepository {
    suspend fun getAlertsData(): Resource<AlertInfo>

    suspend fun getImages(): Call<String>?
}