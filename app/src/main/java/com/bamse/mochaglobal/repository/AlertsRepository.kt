package com.bamse.mochaglobal.repository

import com.bamse.mochaglobal.util.Resource
import com.bamse.mochaglobal.weatherAlerts.AlertInfo

interface AlertsRepository {
    suspend fun getAlertsData(): Resource<AlertInfo>
}