object MainMenu : Menu() {
    override val menuTitle = "\nГлавное меню приложения 'Заметки':\n"
    override val menuItems = arrayListOf(
        "Создать архив",
        "Выбрать созданный архив",
        "Выход"
    )
    override var error =
        "\nВведите значение ещё раз. !! Внимание !! Введенное значение должно быть в диапазоне от 0 до ${menuItems.size - 1}"
    internal val archives: ArrayList<Archive> = arrayListOf()
    fun selectMenu() {
        while (true) {
            output(menuItems, -1, false, error)

            val userInput = input()
            if (userInput.isValidInt()) {
                when (userInput.toInt()) {
                    0 -> ArchiveCreator.selectMenu()
                    1 -> ArchiveChooser.selectMenu()
                    2 -> return
                    else -> output(menuItems, -1, true, error)
                }
                continue
            } else {
                output(menuItems, -1, true, error)
            }
        }
    }

    fun makeArchive(title: String) {
        archives.add(Archive(title))
    }

    fun makeNote(indexArchive: Int, titleNote: String, descriptionNote: String) {
        archives[indexArchive].notes.add(Note(titleNote, descriptionNote))
    }

    override fun output(
        menuItems: ArrayList<String>,
        itemIndex: Int,
        hasError: Boolean,
        error: String
    ) = if (!hasError) {
        println(menuTitle)
        menuItems.forEachIndexed { index, menuItem -> println("$index. $menuItem") }
    } else {
        println(error)
    }
}



