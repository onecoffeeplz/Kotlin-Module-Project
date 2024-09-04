fun createArchive(archives: MutableMap<Int, Archive>) {
    println("Введите название архива:")
    val name: String = checkInput(scanner.nextLine().trim())
    archives.put(archives.size + 1, Archive(name))
    println("Архив '$name' создан!")
    chooseArchiveMenu(archives)
}

fun createNote(archives: MutableMap<Int, Archive>, archiveId: Int) {
    val archive = archives.getValue(archiveId)
    println("Введите название заметки:")
    val name : String = checkInput(scanner.nextLine().trim())
    println("Введите содержимое заметки:")
    val content : String = checkInput(scanner.nextLine().trim())
    if (archive.notes.isNullOrEmpty()) {
        archive.notes = mutableMapOf(1 to Note(archiveId, name, content))
    } else {
        archive.notes!!.put(archive.notes!!.size + 1, Note(archiveId, name, content))
    }
    println("Заметка '$name' создана!")
    chooseNoteMenu(archives, archiveId)
}

fun showNoteContent(archives: MutableMap<Int, Archive>, archiveId: Int, noteId: Int) {
    val noteName : String = archives.getValue(archiveId).notes!!.getValue(noteId).name
    print("Содержимое заметки '$noteName': ")
    println(archives.getValue(archiveId).notes!!.getValue(noteId).content)
    showNoteContentMenu(archives, archiveId, noteId)
}