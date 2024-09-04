fun getUserChoice(maxValue: Int): Int {
    val userAction = scanner.nextLine().trim()
    if (userAction.toIntOrNull() != null && userAction.toInt() <= maxValue) {
        return userAction.toInt()
    } else {
        println("Неверно введен номер пункта, необходимо ввести число от 0 до $maxValue. Попробуйте еще раз!")
        return -1
    }
}

fun checkInput(userInput: String) : String {
    var newInput = userInput
    while (newInput.isBlank()) {
        println("Необходимо ввести данные!")
        newInput = scanner.nextLine().trim()
    }
    return newInput
}