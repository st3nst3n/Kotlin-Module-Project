object NoteViewer : Menu() {
    override var menuTitle = "Меню просмотра заметки:"
    override val menuItems = arrayListOf("\nЧтобы выйти, введите 0")
    override var error = menuItems[0]
    fun selectMenu(indexArchive: Int, indexNote: Int) {
        while (true) {
            output(menuItems, -1, false, error)
            println(MainMenu.archives[indexArchive].notes[indexNote].toString())
            val userInput = input()
            if (userInput.toInt() == 0) {
                return
            } else {
                output(menuItems, -1, true, error)
            }
        }
    }

    override fun output(
        menuItems: ArrayList<String>,
        itemIndex: Int,
        hasError: Boolean,
        error: String
    ) {
        if (!hasError) {
            println(menuTitle)
            menuItems.forEach { menuItem -> println(menuItem) }
        } else {
            println(error)
        }
    }
}