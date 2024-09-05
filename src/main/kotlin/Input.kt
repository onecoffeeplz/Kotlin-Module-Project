fun checkInput(userInput: String): String {
    var newInput = userInput
    while (newInput.isBlank()) {
        println("Необходимо ввести данные!")
        newInput = scanner.nextLine().trim()
    }
    return newInput
}