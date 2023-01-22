object NoteCreator : Menu() {
    override var menuTitle = "\nМеню создания заметок:\n"
    override val menuItems = arrayListOf(
        "Чтобы создать заметку введите название заметки, затем введите описание заметки",
        "Введите 0, чтобы выйти из меню создания заметок"
    )
    override var error: String = ""
    fun selectMenu(indexArchive: Int) {
        while (true) {
            output(menuItems, -1, false, error)
            when (val userInput = input()) {
                "0" -> return
                else -> {
                    val descriptionNote = input()
                    MainMenu.makeNote(indexArchive, userInput, descriptionNote)
                    println("Была добавлена заметка '$userInput'")
                }
            }
        }
    }

    override fun output(
        menuItems: ArrayList<String>,
        itemIndex: Int,
        hasError: Boolean,
        error: String
    ) {
        println(menuTitle)
        menuItems.forEach { menuItem -> println(menuItem) }
    }
}
