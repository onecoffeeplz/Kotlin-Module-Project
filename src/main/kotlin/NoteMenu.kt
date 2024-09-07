class NoteMenu(archiveMenu: ArchiveMenu, archive: Archive) {

    private var notes = archive.notes

    private val noteMenuViewer = Menu()
    private var topMenu = "\n[Архив '${archive.name}'] Выберите действие:"
    private val onSelect: (Note) -> Unit = { note -> showNoteContent(note) }
    private val onCreate: (MutableList<Note>) -> Unit = { notes -> createNote(notes) }
    private val onExit: () -> Unit = { archiveMenu.show() }

    fun show() {
        noteMenuViewer.displayAndRunSelected(
            topMenu, notes, onSelect = onSelect,
            onCreate = onCreate, onExit = onExit
        )
    }

    private fun createNote(notes: MutableList<Note>) {
        println("\nВведите название заметки:")
        val name: String = checkInput(scanner.nextLine().trim())
        println("Введите содержимое заметки:")
        val content: String = checkInput(scanner.nextLine().trim())
        notes.add(Note(name, content))
        println("Заметка '$name' создана!")
        show()
    }

    private fun showNoteContent(note: Note) {
        print("\nСодержимое заметки '${note.name}': ")
        println(note.content)
        show()
    }
}