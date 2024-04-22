package ru.otus.homework

import kotlin.random.Random


fun main() {
    for (i in 0 until 3) {
        if (Random.nextInt(0, 10) > 7) {
            println("Early return from `repeat`")
            return
        }
        println("Iteration $i")
    }
    println("End of `main`")
}



