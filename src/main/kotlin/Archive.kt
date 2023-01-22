class Archive (
    internal var title: String,
    var notes: ArrayList<Note> = arrayListOf()
    ) {
        override fun toString(): String {
            return title
        }
    }