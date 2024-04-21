package ru.otus.homework

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract
import kotlin.random.Random

fun main() {
    val address: Address? = if (Random.nextBoolean()) Address() else null
    if (address.isNotNull()) {
        address.street1 = "Ul. Lenina, d. 10"
    }
}

@OptIn(ExperimentalContracts::class)
fun Address?.isNotNull(): Boolean {
    contract { returns() implies (this@isNotNull != null) }
    return null != this
}