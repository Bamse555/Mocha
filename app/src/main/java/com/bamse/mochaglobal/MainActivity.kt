package com.bamse.mochaglobal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rental1 = Rental(Car("Mustang", CarType.MUSCLE.ordinal), 5)
        val rental2 = Rental(Car("Lambo", CarType.SUPERCAR.ordinal), 20)
        val customer = Customer("Liviu")
        customer.addRental(rental1)
        customer.addRental(rental2)
        println("Bamse " + customer.billingStatement())
    }
}