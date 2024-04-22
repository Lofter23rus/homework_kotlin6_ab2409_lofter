package ru.otus.homework


fun main() {
    val address = Address().apply {
        street1 = "Ul. Lenina, d. 10"
        street2 = "Kv. 10"
        city = "Borok"
        country = "Russia"
        index = "12345"
    }

    val someNewAddress = "Hello, world!"

    // Подставляется тело функции updateAddress
    println("Updating address...")
    // ----- тело лямбда-функции -----
    address.street1 = someNewAddress
    address.street2 = "Kv. 110"
    // ----- конец тела лямбда-функции -----
    println("Address updated")
    // Конец подстановки updateAddress

    println(address.street1)
    println(address.street2)
}



