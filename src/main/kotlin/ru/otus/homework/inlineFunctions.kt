package ru.otus.homework

import kotlin.random.Random


fun main() {
    repeat(3) {
        if (Random.nextInt(0, 10) > 7) {
            println("Early return from `repeat`")
            return
        }
        println("Iteration $it")
    }
    println("End of `main`")
}



