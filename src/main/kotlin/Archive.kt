data class Archive (
    var name: String,
    var notes: MutableMap<Int, Note>? = mutableMapOf()
)