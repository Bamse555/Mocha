package com.bamse.mochaglobal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bamse.mochaglobal.refactoredCarClass.Car
import com.bamse.mochaglobal.refactoredCarClass.CarType
import com.bamse.mochaglobal.refactoredCarClass.Customer
import com.bamse.mochaglobal.refactoredCarClass.Rental

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rental1 = Rental(Car("Mustang", CarType.MUSCLE.index), 5)
        val rental2 = Rental(Car("Lambo", CarType.SUPERCAR.index), 20)
        val customer = Customer("Liviu")
        customer.addRental(rental1)
        customer.addRental(rental2)
        println("Bamse " + customer.billingStatement())
    }
}