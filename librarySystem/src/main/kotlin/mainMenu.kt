
val quitKey = "y"

fun mainMenu() {

    if (quitKey == "y") {
        println("\n  Welcome to our library system  ")
        println("---------------------------------")
        println("1. Category options")
        println("2. Book options")
        println("0. Quit")
        println("\nEnter a number:")
        val chosenOption = readln().toInt()

        if (chosenOption != 0 && chosenOption == 1 || chosenOption == 2) {
            when (chosenOption) {
                1 -> categoryOptionsList()
                2 -> bookOptionsList()
            }
        }
        else if (chosenOption == 0)
        {
            println("Bye Bye")
            return
        }
        quit(quitKey)

    }

}

//-------------------------------------------------------------------

fun quit(outKey: String): Boolean {

    var key = outKey
    println("want to continue? y/n :")
    var i = readln().lowercase()
    key = i
    if (key == "n") {
        println("bye bye")
        return false
    }
    while (key != "n") {
        if (key == "y") {
            mainMenu()
            return true
        } else if (key != "y" || key != "n") {
            println(
                "WRONG ANSWER !! \n" +
                        "want to continue? y/n :"
            )
            var i = readln().lowercase()
            key = i
            if (key == "n") {
                println("bye bye")
                return false
            }
        }
    }
    return false
}
