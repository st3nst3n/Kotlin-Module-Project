object ArchiveChooser : Menu() {
    override var menuTitle = "\nМеню выбора архивов:\n"
    override val menuItems = arrayListOf("\nЧтобы вернуться в главное меню, введите 0")
    override var error =
        "\nВведите значение ещё раз. !! Внимание !! Введенное значение должно быть в диапазоне от 0 до ${MainMenu.archives.size}"

    fun selectMenu() {
        while (true) {
            output(menuItems, -1, false, error)
            val userInput = input()
            if (userInput.isValidInt()) {
                if (MainMenu.archives.size == 0) {
                    if (userInput.toInt() != 0) {
                        println(menuItems[0])
                    } else {
                        return
                    }
                } else {
                    if (userInput.toInt() in (0..MainMenu.archives.size)) {
                        if (userInput.toInt() == MainMenu.archives.size) {
                            return
                        } else {
                            ArchiveViewer.selectMenu(userInput.toInt())
                            continue
                        }
                    } else {
                        output(menuItems, -1, true, error)
                    }
                }
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
            if (MainMenu.archives.size == 0) {
                println("Отсутствуют архивы для просмотра. Создайте архив. ${menuItems[0]}")
            } else {
                println("Общее количество архивов - ${MainMenu.archives.size}.")
                MainMenu.archives.forEachIndexed { indexArchive, archive -> println("$indexArchive. $archive") }
                println("${MainMenu.archives.size}. Вернуться в главное меню приложения")
            }
        } else {
            println(error)
        }
    }
}