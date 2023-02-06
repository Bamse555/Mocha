package com.bamse.mochaglobal.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import com.bamse.mochaglobal.models.AlertsModel
import com.bamse.mochaglobal.ui.theme.Background
import kotlinx.coroutines.launch
import kotlin.random.Random

@Composable
fun AlertsForecast(
    state: AlertState,
    modifier: Modifier = Modifier,
    viewModel: AlertsModel
) {
    state.alertInfo?.alertsData?.get(0)?.let { data ->
        var stateIsGood = rememberLazyListState()

        var offset = 0f
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            LazyColumn(
                modifier = Modifier
                    .scrollable(
                        orientation = Orientation.Vertical,
                        state = rememberScrollableState { delta ->
                            offset += delta
                            viewModel.viewModelScope.launch {
                                //dividing by N the delta for N times slower vertical scroll,
                                //you can change direction by making it a negative number
                                stateIsGood.scrollBy(-delta / 4)
                            }
                            delta
                        }
                    ),
                state = stateIsGood,
                userScrollEnabled = false,
                content = {
                    items(data, key = { message ->
                        // Return a stable + unique key for the item
                        message.id
                    }) { alertData ->
                        AlertDisplay(
                            modifier = Modifier
                                .fillMaxWidth(1f)
                                .padding(vertical = 16.dp)
                                .background(Background),
                            alertData = alertData,
                            alertImage = state.alertImages?.get(
                                data.indexOf(alertData),
                            )
                        )
                    }
                })
        }
    }
}