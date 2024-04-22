package ru.otus.homework

import kotlin.properties.PropertyDelegateProvider
import kotlin.random.Random
import kotlin.reflect.KProperty

fun main() {
    val box = RandomNumberBox()
    box.number = Random.nextInt(100)
    println("Random number: ${box.number}")
}

class RandomNumberBox {
    var number by SomeNumber()
}

class SomeNumber() {
    private var value: Int = 0

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        println("Returning number from '${property.name}' in $thisRef.")
        return value
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        println("Setting number to '$value' in '${property.name}' in $thisRef.")
        this.value = value
    }
}