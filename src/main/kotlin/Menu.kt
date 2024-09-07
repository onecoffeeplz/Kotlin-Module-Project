class Menu() {

    fun <T> displayAndRunSelected(
        topMenu: String, itemList: MutableList<T>,
        onSelect: (T) -> Unit, onCreate: (MutableList<T>) -> Unit, onExit: () -> Unit
    ) {
        while (true) {
            println(topMenu)
            println("0. Создать")
            itemList.forEachIndexed { index, item -> println("${index + 1}. Посмотреть $item") }
            println("${itemList.size + 1}. Выход")
            print("Ваш выбор: ")

            val userAction = scanner.nextLine().trim().toIntOrNull()
            when (userAction) {
                0 -> onCreate(itemList)
                in 1..itemList.size -> onSelect(itemList[userAction!! - 1])
                itemList.size + 1 -> onExit()
                else -> {
                    println("Неверно введен номер пункта, необходимо ввести число от 0 до ${itemList.size + 1}. Попробуйте еще раз!")
                    continue
                }
            }
        }
    }
}