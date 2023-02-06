package com.bamse.mochaglobal.models

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bamse.mochaglobal.repository.AlertsRepository
import com.bamse.mochaglobal.ui.AlertState
import com.bamse.mochaglobal.util.ApiResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class AlertsModel @Inject constructor(
    private val repository: AlertsRepository,
) : ViewModel() {

    var state by mutableStateOf(AlertState())
        private set

    val TAG = "AlertsModel"

    fun loadAlerts() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )

            when (val alertResult = repository.getAlertsData()) {
                is ApiResponse.Success -> {
                    val imagesURLs = arrayListOf<String>()
                    val stringCall: Call<String>? = repository.getImages()
                    val data =
                        if (alertResult.data?.alertsData?.get(0) != null) alertResult.data.alertsData[0] else null
                    data?.forEach { alertData ->
                        stringCall?.clone()?.enqueue(object : Callback<String?> {
                            override fun onResponse(
                                call: Call<String?>,
                                response: Response<String?>
                            ) {
                                response.raw().request.url.let {

                                    if (!imagesURLs.contains(it.toString())) {
                                        imagesURLs.add(it.toString())
                                    }

                                    if (data.indexOf(alertData) != 0 && data.indexOf(alertData) % 5 == 0) {
                                        state = state.copy(
                                            isLoading = false,
                                            alertInfo = alertResult.data,
                                            alertImages = imagesURLs,
                                            error = null
                                        )
                                    }
                                }
                            }

                            override fun onFailure(call: Call<String?>, t: Throwable) {
                                t.message?.let {
                                    Log.e(TAG, it)
                                }
                            }
                        })
                    }

                    state = state.copy(
                        isLoading = false,
                        alertInfo = alertResult.data,
                        alertImages = null,
                        error = null
                    )
                }
                is ApiResponse.Error -> {
                    state = state.copy(
                        alertInfo = null,
                        isLoading = false,
                        error = alertResult.message
                    )
                }

            }
        }
    }
}