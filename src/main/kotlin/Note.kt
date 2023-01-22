class Note (
    internal val title: String,
    private val description: String
    ) {
        override fun toString(): String {
            return "$title:  $description"
        }
    }