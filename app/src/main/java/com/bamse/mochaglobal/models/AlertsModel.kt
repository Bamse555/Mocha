package com.bamse.mochaglobal.models

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bamse.mochaglobal.repository.AlertsRepository
import com.bamse.mochaglobal.ui.AlertState
import com.bamse.mochaglobal.util.Resource
import com.google.gson.Gson
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

    fun loadAlerts() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )

            when (val alertResult = repository.getAlertsData()) {
                is Resource.Success -> {
                    var imageURL = ""
                    val stringCall: Call<String>? = repository.getImages()
                    stringCall?.enqueue(object : Callback<String?> {
                        override fun onResponse(call: Call<String?>, response: Response<String?>) {
                            response.raw().request.url.let {
                                imageURL = it.toString()
                                Log.i("Bamse ok", it.toString())
                            }
                            state = state.copy(
                                isLoading = false,
                                alertInfo = alertResult.data,
                                alertImage = imageURL,
                                error = null
                            )
                        }

                        override fun onFailure(call: Call<String?>, t: Throwable) {
                            t.message?.let { Log.e("Bamse error", it) }
                        }
                    })
                }
                is Resource.Error -> {
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