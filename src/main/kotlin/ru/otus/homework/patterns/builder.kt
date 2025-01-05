package ru.otus.homework.patterns

fun main() {
    // первый экземпляр, пропускаем свойства "classtype", "fFueltype"
    val sedan = Car.Builder()
        .bodytype("седан")
        .awd(false)
        .color("белый")
        .build()
    // второй экземпляр, пропускаем свойство "awd"
    val sedan2 = Car.Builder()
        .bodytype("седан")
        .classtype("D")
        .color("белый")
        .fFueltype("дизельное топливо")
        .build()
    // третий экземпляр, указываем все свойства
    val jeep = Car.Builder()
        .bodytype("джип")
        .classtype("С")
        .awd(true)
        .color("черный")
        .fFueltype("электричка")
        .build()

    println("В продаже следующие авто")
    println("кузов: ${sedan.bodytype}, ${sedan.classtype} класс, топливо: ${sedan.fFueltype}, цвет: ${sedan.color}, " +
            "полный привод: ${sedan.awd}")
    println("кузов: ${sedan2.bodytype}, ${sedan2.classtype} класс, топливо: ${sedan2.fFueltype}, цвет: ${sedan2.color}, " +
            "полный привод: ${sedan2.awd}")
    println("кузов: ${jeep.bodytype}, ${jeep.classtype} класс, топливо: ${jeep.fFueltype}, цвет: ${jeep.color}, " +
            "полный привод: ${jeep.awd}")
}

// Класс позволяет собрать новый экземпляр указывая свои параметры для сборки
//   и допускает пропускать параметры, будут заполнены значениями "по умолчанию"
class Car private constructor(
    val bodytype: String,
    val classtype: String,
    val awd: Boolean,
    val color: String,
    val fFueltype: String
) {
    data class Builder(
        var bodytype: String = "Седан",
        var classtype: String = "B",
        var awd: Boolean = false,
        var color: String = "Белый",
        var fFueltype: String = "Бензин"
    ) {
        fun bodytype(value: String) = apply { this.bodytype = value }
        fun classtype(value: String) = apply { this.classtype = value }
        fun awd(value: Boolean) = apply { this.awd = value }
        fun color(value: String) = apply { this.color = value }
        fun fFueltype(value: String) = apply { this.fFueltype = value }
        fun build() = Car(bodytype, classtype, awd, color, fFueltype)
    }
}

