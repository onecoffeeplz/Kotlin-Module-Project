import kotlin.system.exitProcess

class ArchiveMenu() {

    private val archives: MutableList<Archive> = mutableListOf()

    private val archiveMenuViewer = Menu()
    private val topMenu = "\n[Главное меню] Выберите действие:"
    private val onSelect: (Archive) -> Unit = { archive -> selectArchive(archive) }
    private val onCreate: (MutableList<Archive>) -> Unit = { archives -> createArchive(archives) }
    private val onExit: () -> Unit = { exitProcess(0) }

    fun show() {
        archiveMenuViewer.displayAndRunSelected(
            topMenu, archives, onSelect = onSelect,
            onCreate = onCreate, onExit = onExit
        )
    }

    private fun createArchive(archives: MutableList<Archive>) {
        println("\nВведите название архива:")
        val name: String = checkInput(scanner.nextLine().trim())
        archives.add(Archive(name))
        println("Архив '$name' создан!")
        show()
    }

    private fun selectArchive(archive: Archive) {
        val noteMenuViewer = NoteMenu(this, archive)
        noteMenuViewer.show()
    }
}