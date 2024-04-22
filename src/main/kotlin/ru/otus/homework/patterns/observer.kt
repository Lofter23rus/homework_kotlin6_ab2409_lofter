package ru.otus.homework.patterns

import kotlin.random.Random

fun main() {
    val observable = object : Observable() {
        fun run() {
            repeat(3) {
                Thread.sleep(100)
                notifyListeners(Random.nextInt(100))
            }
        }
    }
    val observer1 = Observer("1")
    val observer2 = Observer("2")

    println("First run:")
    observable.addListener(observer1)
    observable.addListener(observer2)
    observable.run()

    println("Second run:")
    observable.removeListener(observer1)
    observable.run()
}

class Observer(private val name: String) {
    fun update(value: Int) {
        println("Listener $name updated with value $value")
    }
}

open class Observable {
    private val observers = mutableListOf<Observer>()

    fun addListener(observer: Observer) {
        observers.add(observer)
    }

    fun removeListener(observer: Observer) {
        observers.remove(observer)
    }

    protected fun notifyListeners(value: Int) {
        observers.forEach { it.update(value) }
    }
}
