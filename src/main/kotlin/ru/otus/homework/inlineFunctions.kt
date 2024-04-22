package ru.otus.homework


fun updateAddress(block: () -> Unit) {
    println("Updating address...")
    block()
    println("Address updated")
}

fun main() {
    val address = Address().apply {
        street1 = "Ul. Lenina, d. 10"
        street2 = "Kv. 10"
        city = "Borok"
        country = "Russia"
        index = "12345"
    }

    val someNewAddress = "Hello, world!"

    updateAddress {
        address.street1 = someNewAddress
        address.street2 = "Kv. 110"
    }

    println(address.street1)
    println(address.street2)
}



