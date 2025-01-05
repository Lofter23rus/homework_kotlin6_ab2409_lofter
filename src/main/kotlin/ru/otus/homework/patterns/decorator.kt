package ru.otus.homework.patterns

import ru.otus.homework.*

fun main() {
    println("Test decorator MyVetClinic")
    val catVet = CatVetImpl("Ivan")
    val dogVet = DogVetImpl("Petr")
    val vetClinic = MyVetClinic(catVet, dogVet)
    vetClinic.treat(Cat())
    vetClinic.treat(Dog())
}
// Добавим функциональности классу VetClinic в случае взятия в работу кошачьих
class MyVetClinic(private val catVet: CatVet, dogVet: DogVet) : VetClinic(catVet, dogVet) {
    override fun treat(cat: Cat) {
        println("MyVetClinic -> super.treat(cat)")
        super.treat(cat)
    }
}
