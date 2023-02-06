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
import com.bamse.mochaglobal.models.AlertsModel
import com.bamse.mochaglobal.ui.AlertsForecast
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.material.Text

import com.bamse.mochaglobal.ui.theme.AlertsAppTheme
import com.bamse.mochaglobal.ui.theme.Background
import com.bamse.mochaglobal.ui.theme.CardBackground


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: AlertsModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.loadAlerts()

        setContent {
            AlertsAppTheme {
                Box(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(CardBackground)
                    ) {
                        Spacer(modifier = Modifier.height(16.dp))
                        AlertsForecast(state = viewModel.state, viewModel = viewModel)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                    if (viewModel.state.isLoading) {
                        CircularProgressIndicator(
                            modifier = Modifier.align(Alignment.Center),
                            color = Background
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