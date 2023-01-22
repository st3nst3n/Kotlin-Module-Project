object ArchiveViewer : Menu() {
    override var menuTitle = "\nМеню архива:"
    override val menuItems = arrayListOf(
        "Создать заметку",
        "Вернуться в меню выбора архивов"
    )
    override var error: String = ""
    fun selectMenu(indexArchive: Int) {
        while (true) {
            output(menuItems, indexArchive, false, error)
            error =
                "Введите значение ещё раз. !! Внимание !! Введенное значение должно быть в диапазоне от 0 до ${MainMenu.archives[indexArchive].notes.size + 1}"
            val userInput = input()
            if (userInput.isValidInt()) {
                if (userInput.toInt() in (0..(MainMenu.archives[indexArchive].notes.size + 1))) {
                    when (userInput.toInt()) {
                        MainMenu.archives[indexArchive].notes.size -> {
                            NoteCreator.selectMenu(indexArchive)
                            continue
                        }
                        MainMenu.archives[indexArchive].notes.size + 1 -> {
                            return
                        }
                        else -> {
                            NoteViewer.selectMenu(indexArchive, userInput.toInt())
                        }
                    }
                } else {
                    output(menuItems, indexArchive, true, error)
                }
            } else {
                output(menuItems, indexArchive, true, error)
            }
        }
    }

    override fun output(
        menuItems: ArrayList<String>,
        itemIndex: Int,
        hasError: Boolean,
        error: String
    ) {
        val noteCreation = "${MainMenu.archives[itemIndex].notes.size}. ${menuItems[0]}"
        val exit = "${MainMenu.archives[itemIndex].notes.size + 1}. ${menuItems[1]}"
        if (!hasError) {
            println("$menuTitle '${MainMenu.archives[itemIndex].title}'\n")
            if (MainMenu.archives[itemIndex].notes.size == 0) {
                println("Заметки отсутствуют. Создайте заметки.\n$noteCreation \n$exit\n")
            } else {
                println("Общее количество заметок в архиве '${MainMenu.archives[itemIndex].title}' - ${MainMenu.archives[itemIndex].notes.size}.\n")
                for (note in MainMenu.archives[itemIndex].notes) {
                    println("${MainMenu.archives[itemIndex].notes.indexOf(note)}. ${note.title}")
                }
                println("$noteCreation \n$exit\n")
            }
        } else {
            println(error)
        }
    }
}