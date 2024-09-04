import kotlin.system.exitProcess

fun chooseArchiveMenu(archives: MutableMap<Int, Archive>) {
    println("""
        [Главное меню] Выберите действие:
        0. Создать архив
    """.trimIndent())
    archives.forEach { (id, archive) -> println("$id. Посмотреть ${archive.name}") }
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

fun chooseNoteMenu(archives: MutableMap<Int, Archive>, archiveId: Int) {
    val archive = archives.getValue(archiveId)
    println("""
        [Архив ${archive.name}] Выберите действие:
        0. Создать заметку
    """.trimIndent())
    archive.notes!!.forEach { (id, note) -> println("$id. Посмотреть ${note.name}") }
    println("${archive.notes!!.size + 1}. Назад")

    val userAction: Int = getUserChoice(archive.notes!!.size + 1)
    when (userAction) {
        -1 -> chooseNoteMenu(archives, archiveId)
        0 -> createNoteMenu(archives, archiveId)
        archive.notes!!.size + 1 -> chooseArchiveMenu(archives)
        else -> {
            showNoteContentMenu(archives, archiveId, userAction)
        }
    }
}

fun createNoteMenu(archives: MutableMap<Int, Archive>, archiveId: Int) {
    println("""
        [Создание заметки в архиве ${archives.getValue(archiveId).name}] Выберите действие:
        0. Задать имя и добавить содержимое
        1. Назад
    """.trimIndent())

    val userAction: Int = getUserChoice(1)
    when (userAction) {
        0 -> createNote(archives, archiveId)
        1 -> chooseNoteMenu(archives, archiveId)
        else -> createNoteMenu(archives, archiveId)
    }
}

fun showNoteContentMenu(archives: MutableMap<Int, Archive>, archiveId: Int, noteId: Int) {
    println("""
        [Просмотр заметки ${archives.getValue(archiveId).notes!!.getValue(noteId).name}] Выберите действие:
        0. Вывести содержимое
        1. Назад
    """.trimIndent())

    val userAction: Int = getUserChoice(1)
    when (userAction) {
        0 -> showNoteContent(archives, archiveId, noteId)
        1 -> chooseNoteMenu(archives, archiveId)
        else -> showNoteContentMenu(archives, archiveId, noteId)
    }
}