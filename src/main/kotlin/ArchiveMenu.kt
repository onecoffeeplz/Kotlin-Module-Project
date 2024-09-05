import kotlin.system.exitProcess

class ArchiveMenu() {

    val archives: MutableList<Archive> = mutableListOf()

    val archiveMenuViewer = Menu()
    val topMenu = "\n[Главное меню] Выберите действие:"
    val onSelect: (Archive) -> Unit = { archive -> selectArchive(archive) }
    val onCreate: (MutableList<Archive>) -> Unit = { archives -> createArchive(archives) }
    val onExit: () -> Unit = { exitProcess(0) }

    fun show() {
        archiveMenuViewer.displayAndRunSelected(
            topMenu, archives, onSelect = onSelect,
            onCreate = onCreate, onExit = onExit
        )
    }

    fun createArchive(archives: MutableList<Archive>) {
        println("\nВведите название архива:")
        val name: String = checkInput(scanner.nextLine().trim())
        archives.add(Archive(name))
        println("Архив '$name' создан!")
        show()
    }

    fun selectArchive(archive: Archive) {
        val noteMenuViewer = NoteMenu(this, archive)
        noteMenuViewer.show()
    }
}