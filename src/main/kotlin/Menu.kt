abstract class Menu {

    abstract val menuTitle: String
    abstract val menuItems: ArrayList<String>
    abstract var error: String

    abstract fun output(
        menuItems: ArrayList<String>,
        itemIndex: Int,
        hasError: Boolean,
        error: String
    )
}