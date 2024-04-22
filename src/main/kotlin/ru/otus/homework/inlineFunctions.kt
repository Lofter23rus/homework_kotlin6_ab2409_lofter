package ru.otus.homework

// Наша функция, которая принимает лямбду
fun updateAddress(block: Function0) {
    println("Updating address...")
    block.invoke()
    println("Address updated")
}

// Интерфейс для функции, котоая под капотом лямбды
interface Function0 {
    operator fun invoke()
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

    // Создается анонимный объект,
    // который реализует интерфейс Function0
    updateAddress(object : Function0 {
        override fun invoke() {
            address.street1 = someNewAddress
            address.street2 = "Kv. 110"
        }
    })

    println(address.street1)
    println(address.street2)
}



