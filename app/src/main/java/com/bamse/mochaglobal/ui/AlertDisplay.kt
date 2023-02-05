package com.bamse.mochaglobal.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.bamse.mochaglobal.R
import com.bamse.mochaglobal.weatherAlerts.AlertData
import java.time.format.DateTimeFormatter

@Composable
fun AlertDisplay(
    alertData: AlertData,
    alertImage: String?,
    modifier: Modifier = Modifier,
    textColor: Color = Color.White
) {
    Column(
        modifier = modifier.padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Image(
            painter = rememberAsyncImagePainter(alertImage),
            contentDescription = null,
            modifier = Modifier.size(40.dp)
        )

        Spacer(modifier = Modifier.width(6.dp))

        //event name
        Text(
            text = alertData.eventName,
            color = textColor,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.width(6.dp))

        //source name
        Text(
            text = alertData.sourceName,
            color = textColor,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.width(6.dp))

        Text(
            text = "Start: ${alertData.startDate}",
            color = Color.LightGray
        )

        Spacer(modifier = Modifier.width(6.dp))

        Text(

            text = "End: ".plus(remember(alertData) {
                alertData.endDate
            } ?: "NA"),
            color = Color.LightGray
        )

        Spacer(modifier = Modifier.width(6.dp))

        Text(
            text = "Duration: ".plus(remember(alertData) {
                alertData.duration
            } ?: "NA"),
            color = Color.LightGray
        )
    }
}