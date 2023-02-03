package com.bamse.mochaglobal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.bamse.mochaglobal.models.WeatherAlertsModel
import com.bamse.mochaglobal.ui.AlertCard
import com.bamse.mochaglobal.ui.AlertsForecast
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.material.Text

import com.bamse.mochaglobal.ui.theme.DarkBlue
import com.bamse.mochaglobal.ui.theme.DeepBlue
import com.bamse.mochaglobal.ui.theme.WeatherAlertsAppTheme
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.OkHttpClient







@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: WeatherAlertsModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.loadWeatherAlertInfo()

        setContent {
            WeatherAlertsAppTheme {
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(DarkBlue)
                    ) {
                        AlertCard(
                            state = viewModel.state,
                            backgroundColor = DeepBlue
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        AlertsForecast(state = viewModel.state)
                    }
                    if(viewModel.state.isLoading) {
                        CircularProgressIndicator(
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                    viewModel.state.error?.let { error ->
                        Text(
                            text = error,
                            color = Color.Red,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }
        }

//        val rental1 = Rental(Car("Mustang", CarType.MUSCLE.index), 5)
//        val rental2 = Rental(Car("Lambo", CarType.SUPERCAR.index), 20)
//        val customer = Customer("Liviu")
//        customer.addRental(rental1)
//        customer.addRental(rental2)
    }
}