object ArchiveCreator : Menu() {
    override val menuTitle: String = "\nМеню создания архивов:\n"
    override val menuItems: ArrayList<String> = arrayListOf(
        "Введите название архива или введите 0, чтобы вернуться в главное меню приложения",
    )
    override var error: String = ""
    fun selectMenu() {
        while (true) {
            output(menuItems, -1, false, error)
            when (val userInput = input()) {
                "0" -> return
                else -> {
                    MainMenu.makeArchive(userInput)
                    println("\nБыл добавлен архив: $userInput")
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
