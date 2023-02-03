package com.bamse.mochaglobal.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bamse.mochaglobal.repository.AlertsRepository
import com.bamse.mochaglobal.ui.AlertState
import com.bamse.mochaglobal.util.Resource
import com.bamse.mochaglobal.weatherAlerts.AlertInfo

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlertsModel @Inject constructor(
    private val repository: AlertsRepository,
) : ViewModel() {

    var state by mutableStateOf(AlertState())
        private set

    fun loadWeatherAlertInfo() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )

            when (val result =
                repository.getAlertsData()) {
                is Resource.Success -> {
                    state = state.copy(
                        alertInfo = result.data as? AlertInfo,
                        isLoading = false,
                        error = null
                    )
                }
                is Resource.Error -> {
                    state = state.copy(
                        alertInfo = null,
                        isLoading = false,
                        error = result.message
                    )
                }
            }
        }
    }
}