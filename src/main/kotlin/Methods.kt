import java.util.*

fun String.isValidInt(): Boolean {
    return this.toIntOrNull() != null
}

fun input(): String {
    val scanner = Scanner(System.`in`)
    return scanner.nextLine()
}
