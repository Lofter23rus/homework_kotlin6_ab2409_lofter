package ru.otus.homework

import kotlin.properties.PropertyDelegateProvider
import kotlin.random.Random
import kotlin.reflect.KProperty

fun main() {
    val box = RandomNumberBox()
    box.number = Random.nextInt(100)
    println("Random number: ${box.number}")

    // Lazy initialization
    println("====================")
    println("Creating lazy box")
    val lazyBox = LazyBox()
    println("Accessing value")
    lazyBox.printValue()
}

class RandomNumberBox {
    private val someNumber = SomeNumber()

    var number: Int
        get() = someNumber.getValue(this, RandomNumberBox::number)
        set(value) = someNumber.setValue(this, RandomNumberBox::number, value)
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

class LazyBox {
    private val value: String by lazy {
        println("Lazy initialization")
        "Hello"
    }

    fun printValue() {
        println(value)
    }
}