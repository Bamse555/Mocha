package com.bamse.mochaglobal

enum class CarType (val type: Int, val initialAmount: Double, val minDaysToRent: Int, val amountPerDay: Double){
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

        var totalAmount = 0.0
        var frequentRenterPoints = 0

        val iterator = _rentals.iterator()
        var result = "Rental Record for " + getName() + "\n"

        while (true) {
            try {
                val each = iterator.next()
                var thisAmount= 0.0

                //determine amounts for each line
                when (each.getCar().getPriceCode()) {
                    CarType.ECONOMY.ordinal -> {
                        thisAmount += 80
                        if (each.getDaysRented() > 2) {
                            thisAmount += ((each.getDaysRented()) - 2).toDouble() * 30.0
                        }
                    }
                    CarType.SUPERCAR.ordinal ->
                        thisAmount += (each.getDaysRented()).toDouble() * 200.0
                    CarType.MUSCLE.ordinal -> {
                        thisAmount += 200
                        if (each.getDaysRented() > 3) {
                            thisAmount += ((each.getDaysRented()).toDouble() - 3) * 50.0
                        }
                    }
                }
                // add frequent renter points
                frequentRenterPoints += 1
                // add bonus for a two day new release rental
                if ((each.getCar().getPriceCode() == CarType.SUPERCAR.ordinal) && each.getDaysRented() > 1) { frequentRenterPoints += 1 }
                //show figures for this rental
                result += "\t" + each.getCar().getTitle() + "\t" + thisAmount.toString() + "\n"
                totalAmount += thisAmount
            } catch (e: java.util.NoSuchElementException){
                break
            }
        }

        //add footer lines
        result += "Final rental payment owed " + totalAmount.toString() + "\n"
        result += "You received an additional " + frequentRenterPoints.toString() + " frequent customer points"; return result
    }
}



