package com.bamse.mochaglobal.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bamse.mochaglobal.repository.WeatherAlertsRepository
import com.bamse.mochaglobal.ui.AlertState
import com.bamse.mochaglobal.util.Resource
import com.bamse.mochaglobal.weatherAlerts.WeatherAlertInfo

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherAlertsModel @Inject constructor(
    private val repository: WeatherAlertsRepository,
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
                repository.getWeatherAlertsData()) {
                is Resource.Success -> {
                    state = state.copy(
                        weatherAlertInfo = result.data as? WeatherAlertInfo,
                        isLoading = false,
                        error = null
                    )
                }
                is Resource.Error -> {
                    state = state.copy(
                        weatherAlertInfo = null,
                        isLoading = false,
                        error = result.message
                    )
                }
            }
        }
    }
}