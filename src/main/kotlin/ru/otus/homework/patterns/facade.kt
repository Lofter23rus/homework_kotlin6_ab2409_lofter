package ru.otus.homework.patterns

import ru.otus.homework.Cat
import ru.otus.homework.CatVetImpl
import ru.otus.homework.Dog
import ru.otus.homework.DogVetImpl

fun main() {
    val clinic = VetClinicFacade()
    clinic.treatCat(Cat())
    clinic.treatDog(Dog())
}

class VetClinicFacade {
    private val catVet = CatVetImpl("Ivan")
    private val dogVet = DogVetImpl("Petr")

    private fun registerPet(pet: Any) {
        println("Pet registered")
    }

    fun treatCat(cat: Cat) {
        registerPet(cat)
        catVet.treat(cat)
    }

    fun treatDog(dog: Dog) {
        registerPet(dog)
        dogVet.treat(dog)
    }
}