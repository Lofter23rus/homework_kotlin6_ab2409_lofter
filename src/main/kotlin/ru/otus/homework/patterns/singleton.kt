package ru.otus.homework.patterns

import java.util.*
import kotlin.system.measureTimeMillis

fun main() {
    println("Test started")
    val ms1 = MySingleton.value
    println(ms1)
    val ms2 = MySingleton.value
    println(ms2)
    println("ms1 === ms2: ${ms1 === ms2}")
}
// один объект для всех экземпляров
object MySingleton {
    val value : String = UUID.randomUUID().toString()
}

