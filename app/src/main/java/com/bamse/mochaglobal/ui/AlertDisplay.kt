package com.bamse.mochaglobal.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.bamse.mochaglobal.alerts.AlertData
import com.bamse.mochaglobal.ui.theme.CardBackground

@Composable
fun AlertDisplay(
    modifier: Modifier = Modifier,
    alertData: AlertData,
    alertImage: String?,
    textColor: Color = Color.White
) {
    Column(
        modifier = modifier.padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        if (alertImage!= null)
            AsyncImage(
                model = alertImage,
                contentDescription = null
            )
        else
            CircularProgressIndicator(color = CardBackground)

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