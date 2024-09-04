fun chooseNoteMenu(archives: MutableMap<Int, Archive>, archiveId: Int) {
    val archive = archives.getValue(archiveId)
    println("""
        [Архив '${archive.name}'] Выберите действие:
        0. Создать заметку
    """.trimIndent())
    archive.notes!!.forEach { (id, note) -> println("$id. Посмотреть '${note.name}'") }
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
    val archiveName : String = archives.getValue(archiveId).name
    println("""
        [Создание заметки в архиве '$archiveName'] Выберите действие:
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
    val noteName : String = archives.getValue(archiveId).notes!!.getValue(noteId).name
    println(
        """
        [Просмотр заметки '$noteName'] Выберите действие:
        0. Вывести содержимое
        1. Назад
    """.trimIndent()
    )

    val userAction: Int = getUserChoice(1)
    when (userAction) {
        0 -> showNoteContent(archives, archiveId, noteId)
        1 -> chooseNoteMenu(archives, archiveId)
        else -> showNoteContentMenu(archives, archiveId, noteId)
    }
}
