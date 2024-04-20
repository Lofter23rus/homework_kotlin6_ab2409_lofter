package ru.otus.homework

fun main() {
    val address = Address()

    address.street1 = "Ul. Lenina, d. 10"
    address.street2 = "Kv. 10"
    address.city = "Borok"
    address.country = "Russia"
    address.index = "12345"

    println(address)
}

class Address {
    lateinit var street1: String
    lateinit var street2: String
    lateinit var city: String
    lateinit var country: String
    lateinit var index: String
}