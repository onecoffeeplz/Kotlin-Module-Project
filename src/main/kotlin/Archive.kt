data class Archive(
    var name: String,
    var notes: MutableList<Note> = mutableListOf()
) {
    override fun toString(): String = "архив '$name'"
}