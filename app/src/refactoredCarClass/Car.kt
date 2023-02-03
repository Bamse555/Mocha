package com.bamse.mochaglobal.refactoredCarClass

enum class CarType (val index: Int, val initialAmount: Double, val minDaysToRent: Int, val amountPerDay: Double){
    MUSCLE (2, 200.0, 3, 50.0),
    ECONOMY (0, 80.0, 2, 30.0),
    SUPERCAR (1, 0.0, 0, 200.0);
}

class Car(title: String, priceCode: Int) {

    private val _title: String = title
    private var _priceCode: Int = priceCode

    fun getPriceCode(): Int {
        return _priceCode
    }

    fun getTitle(): String {
        return _title
    }
}


class Rental(car: Car, daysRented: Int) {
    private val _car : Car = car
    private val _daysRented: Int = daysRented

    fun getDaysRented(): Int {
        return _daysRented
    }
    fun getCar() : Car {
        return _car
    }
}

class Customer(name: String) {
    private val _name: String = name
    private var _rentals = ArrayList<Rental>()

    fun addRental(arg: Rental) {
        _rentals.add(arg)
    }
    private fun getName(): String {
        return _name
    }

    fun billingStatement(): String {

        var result = "Rental Record for " + getName() + "\n"
        var totalAmount = 0.0
        var frequentRenterPoints = 0
        var thisAmount: Double
        _rentals.forEach { rental ->
            thisAmount = 0.0
            val carType =
                CarType.values().first { it.index == rental.getCar().getPriceCode() }
            val daysRented = rental.getDaysRented()
            //add initial amount
            thisAmount += carType.initialAmount

            //add days rented amount
            if (daysRented > carType.minDaysToRent) {
                thisAmount += (daysRented - carType.minDaysToRent) * carType.amountPerDay
            }

            frequentRenterPoints += 1
            // add bonus for a two day new release rental
            if ((carType.index == CarType.SUPERCAR.index) && daysRented > 1) {
                frequentRenterPoints += 1
            }

            //show figures for this rental
            result += "\t" + rental.getCar().getTitle() + "\t" + thisAmount.toString() + "\n"
            totalAmount += thisAmount

        }

        //add footer lines
        result += "Final rental payment owed $totalAmount\n"
        result += "You received an additional $frequentRenterPoints frequent customer points"; return result
    }
}



