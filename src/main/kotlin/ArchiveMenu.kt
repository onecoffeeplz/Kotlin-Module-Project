import kotlin.system.exitProcess

fun chooseArchiveMenu(archives: MutableMap<Int, Archive>) {
    println("""
        [Главное меню] Выберите действие:
        0. Создать архив
    """.trimIndent())
    archives.forEach { (id, archive) -> println("$id. Посмотреть '${archive.name}'") }
    println("${archives.size + 1}. Выйти из программы")

    val userAction: Int = getUserChoice(archives.size + 1)
    when (userAction) {
        -1 -> chooseArchiveMenu(archives)
        0 -> createArchiveMenu(archives)
        archives.size + 1 -> exitProcess(0)
        else -> chooseNoteMenu(archives, userAction)
    }
}

fun createArchiveMenu(archives: MutableMap<Int, Archive>) {
    println("""
        [Создание архива] Выберите действие:
        0. Задать имя
        1. Назад
    """.trimIndent())

    val userAction: Int = getUserChoice(1)
    when (userAction) {
        0 -> createArchive(archives)
        1 -> chooseArchiveMenu(archives)
        else -> {
            createArchiveMenu(archives)
        }
    }
}