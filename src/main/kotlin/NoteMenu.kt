class NoteMenu(archiveMenu: ArchiveMenu, archive: Archive) {
    var notes = archive.notes
    var topMenu = "\n[Архив '${archive.name}'] Выберите действие:"
    val noteMenuViewer = Menu()
    val onSelect: (Note) -> Unit = { note -> showNoteContent(note) }
    val onCreate: (MutableList<Note>) -> Unit = { notes -> createNote(notes) }
    val onExit: () -> Unit = { archiveMenu.show() }

    fun show() {
        noteMenuViewer.displayAndRunSelected(
            topMenu, notes, onSelect = onSelect,
            onCreate = onCreate, onExit = onExit
        )
    }

    fun createNote(notes: MutableList<Note>) {
        println("\nВведите название заметки:")
        val name: String = checkInput(scanner.nextLine().trim())
        println("Введите содержимое заметки:")
        val content: String = checkInput(scanner.nextLine().trim())
        notes.add(Note(name, content))
        println("Заметка '$name' создана!")
        show()
    }

    fun showNoteContent(note: Note) {
        print("\nСодержимое заметки '${note.name}': ")
        println(note.content)
        show()
    }
}