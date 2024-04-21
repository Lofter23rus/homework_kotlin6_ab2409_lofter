package ru.otus.homework

import kotlin.random.Random

fun main() {
    val address: Address? = if (Random.nextBoolean()) Address() else null
    if (address.isNotNull()) {
        address.street1 = "Ul. Lenina, d. 10"
    }
}

fun Address?.isNotNull(): Boolean {
    return null != this
}