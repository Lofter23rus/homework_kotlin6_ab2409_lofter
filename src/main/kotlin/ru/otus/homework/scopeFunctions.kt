package ru.otus.homework

import kotlin.random.Random

fun main() {
    val address: Address? = if (Random.nextBoolean()) Address() else null

    address?.let { addr ->
        addr.street1 = "Ul. Lenina, d. 10"
        addr.street2 = "Kv. 10"
        addr.city = "Borok"
        addr.country = "Russia"
        addr.index = "12345"
    }

    val addressString = address?.let {
        "${it.street1}, ${it.street2}, ${it.city}, ${it.country}, ${it.index}"
    } ?: "Address is not defined"

    println(address)
    println(addressString)
}

class Address {
    lateinit var street1: String
    lateinit var street2: String
    lateinit var city: String
    lateinit var country: String
    lateinit var index: String
}