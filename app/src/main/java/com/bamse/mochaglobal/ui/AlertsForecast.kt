package com.bamse.mochaglobal.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bamse.mochaglobal.ui.theme.Background

@Composable
fun AlertsForecast(
    state: AlertState,
    modifier: Modifier = Modifier
) {
    state.alertInfo?.alertsData?.get(0)?.let { data ->
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            LazyColumn(content = {
                items(data) { weatherData ->
                    AlertDisplay(
                        alertData = weatherData,
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .padding(vertical = 16.dp)
                            .background(Background),
                    )
                }
            })
        }
    }
}