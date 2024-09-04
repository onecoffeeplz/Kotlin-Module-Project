import java.util.Scanner

var scanner = Scanner(System.`in`)

fun main(args: Array<String>) {
    var archives: MutableMap<Int, Archive> = mutableMapOf()
    chooseArchiveMenu(archives)
}