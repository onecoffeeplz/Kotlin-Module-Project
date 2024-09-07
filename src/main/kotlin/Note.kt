data class Note(
    var name: String,
    var content: String
) {
    override fun toString(): String = "заметку '$name'"
}