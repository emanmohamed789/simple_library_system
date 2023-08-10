import java.util.Dictionary

var category = CategoryList()
var book = Book()
fun categoryOptionsList() {
    println("\n---CATEGORY---")
    println("1. Add category")
    println("2. Delete category by ID")
    println("3. Delete category by name")
    println("4. Update category")
    println("5. Show category list")
    println("0. Quit")
    println("\nEnter a number:")
    val chosenOption = readln().toInt()
    if (chosenOption != 0 && chosenOption == 1 || chosenOption == 2 || chosenOption == 3 || chosenOption == 4 || chosenOption == 5) {
        when (chosenOption) {
            1 -> addMenuCategory()
            2 -> deleteByIdMenuCategory()
            3 -> deleteByNameMenuCategory()
            4 -> category.updateCategory()
            5 -> category.showCategory()
        }
    } else if (chosenOption == 0) {
        println("Bye Bye")
        return
    }
}

//-------------------------------------------------------------------

fun addMenuCategory() {

    println("  ADD CATEGORY:  ")
    println("------------------")
    println("Enter the category name : ")
    var categoryName = readln()
    println("Enter the category ID :")
    var categoryID = readlnOrNull()

    if (categoryName.isNotEmpty() && categoryID != null && categoryID.toString() != "") {
        category.addCategory(categoryName, categoryID.toInt())
    } else
        error()
}

//-------------------------------------------------------------------

fun deleteByNameMenuCategory() {

    println("  DELETE CATEGORY BY NAME :  ")
    println("---------------------------")
    println("Enter the category name that you want to delete :")
    var categoryName = readln()

    if (categoryName.isNotEmpty()) {
        category.deleteCategoryByName(categoryName)
        println("hey,Your category is deleted successfully")
    } else
        error()
}

//-------------------------------------------------------------------

fun deleteByIdMenuCategory() {

    println("  DELETE CATEGORY BY ID :  ")
    println("---------------------------")
    println("Enter the category ID that you want to delete :")
    var categoryID = readlnOrNull()

    if (categoryID != null && categoryID.toString() != "") {
        category.deleteCategoryByID(categoryID.toInt())
        println("hey,Your category is deleted successfully")
    } else
        error()
}

//-------------------------------------------------------------------

fun bookOptionsList() {

    println("\n---BOOK---")
    println("1. Add Book")
    println("2. Delete Book")
    println("3- search by name")
    println("4- search by id")
    println("5. Update category")
    println("6. Display Books by category")
    println("0. Quit")
    println("\nEnter a number:")
    val chosenOption = readln().toInt()
    if (chosenOption != 0 && chosenOption == 1 || chosenOption == 2 || chosenOption == 3 || chosenOption == 4 || chosenOption == 5|| chosenOption == 6|| chosenOption == 71) {
        when (chosenOption) {
            1 -> addMenuBook()
            2 -> deleteByIdMenuBook()
            3 -> searchByNameMenuBook()
            4 -> searchByIdMenuBook()
            5 -> updateMenuBook()
            6 -> displayByCategory()
            7 -> display()
        }
    } else if (chosenOption == 0) {
        println("Bye Bye")
        return
    }
}

//-------------------------------------------------------------------

fun addMenuBook() {

    println("  ADD BOOK :  ")
    println("------------------")
    println("Enter the Book name : ")
    var Name = readln()
    println("Enter the Book ID :")
    var ID = readln().toInt()
    println("Enter the Author name :")
    var author = readln()
    category.showCategory()
    println("choose the category ID :")
    var catID = readln().toInt()
    var cat: MutableMap<String, Int>
    cat = category.setCategory(catID, category)

    if (Name.isNotEmpty() && ID != null && ID.toString() != "" && author.isNotEmpty() ) {
       book.addBook(ID,Name,author,cat)
    } else
        error()

}

//-------------------------------------------------------------------

fun searchByNameMenuBook(){

    println("  SEARCH FOR A BOOK BY NAME :  ")
    println("---------------------------")
    println("Enter the book name :")
    var name = readln()

    if (name != null ) {
        book.searchByName(name)
    } else
        error()

}

//-------------------------------------------------------------------

fun searchByIdMenuBook(){

    println("  SEARCH FOR A BOOK BY ID :  ")
    println("---------------------------")
    println("Enter the book ID :")
    var id = readln().toInt()

    if (id != null ) {
        book.searchByID(id)
    } else
        error()

}

//-------------------------------------------------------------------

fun deleteByIdMenuBook(){

    println("  DELETE BOOK BY ID :  ")
    println("---------------------------")
    println("Enter the book ID that you want to delete :")
    var ID = readln().toInt()

    if (ID != null && ID.toString() != "") {
        book.deleteBookByID(ID)
        println("hey,Your book is deleted successfully")
    } else
        error()
}

//-------------------------------------------------------------------

fun updateMenuBook(){

    println("  UPDATE BOOK :  ")
    println("---------------------------")
    println("Enter the ID of the book you want to update: ")
    var ID = readln().toInt()
    book.searchByID(ID)
    println("\nEnter the book new name : ")
    var name = readln()
    println("Enter the Author name :")
    var author = readln()
    category.showCategory()
    println("choose the category ID :")
    var catID = readln().toInt()
    var cat: MutableMap<String, Int>
    cat = category.setCategory(catID, category)
    var newBook =Book.Books(name,author,cat)
    book.update(ID,newBook)


}

//-------------------------------------------------------------------

fun displayByCategory() {
    category.showCategory()
    println("choose the category ID :")
    var catID = readln().toInt()
    var cat: MutableMap<String, Int>
    cat = category.setCategory(catID, category)
    book.displayByCategory(cat)
}

//-------------------------------------------------------------------

fun display() {
    book.displayAll()
}

//-------------------------------------------------------------------

fun error() {
    println("something went wrong !!")
    println("press R for main menu, Q to Quit")
    var restart = readln().lowercase()
    if (restart == "r")
        mainMenu()
    else if (restart == "Q") {
        println("Bye Bye")
        return
    }
}

// THE END