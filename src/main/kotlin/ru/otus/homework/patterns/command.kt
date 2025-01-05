package ru.otus.homework.patterns

fun main() {
    // экземпляр класса
    val door = Door()
    // и экземпляры команд для него
    val doorOpen = DoorOpenCommand(door)
    val doorClose = DoorCloseCommand(door)

    // экземпляр для управления командами
    val remote = DoorControl()
    // формируем список команд - экземпляр класса определен при создании экземпляра команды (см выше)
    remote.addCommand(doorOpen)
    remote.addCommand(doorClose)
    // выполняем все ранее записанные к выполнению команды
    remote.executeCommands()
}

interface Command {
    fun execute()
}
// функции управления дверью
class Door {
    // функция ОТКРЫТЬ дверь
    fun doorOpen() = println("Door open [class Door]")
    // функция ЗАКРЫТЬ дверь
    fun doorClose() = println("Door close [class Door]")
}

// Обертка метода ОТКРЫТЬ в команду с параметром для какого класса команда
class DoorOpenCommand(private val door: Door) : Command {
    override fun execute() {
        println("Door open [DoorOpenCommand]")
        door.doorOpen()
    }
}
// Обертка метода ЗАКРЫТЬ в команду с параметром для какого класса команда
class DoorCloseCommand(private val door: Door) : Command {
    override fun execute() {
        println("Door close [DoorCloseCommand]")
        door.doorClose()
    }
}

// Используем команды для вызова функций класса
class DoorControl {
    // список команд для выполнения
    private val commands = mutableListOf<Command>()
    // добавить команду в список
    fun addCommand(command: Command) = commands.add(command)
    // выполнить все команды списка
    fun executeCommands() = commands.forEach { it.execute() }
}

