class Book {

    data class Books(
        var bookName: String,
        var authorName: String,
        var category: MutableMap<String, Int> = mutableMapOf()
    )

    //-------------------------------------------------------------------

    var book: MutableMap<Int, Books> = mutableMapOf()

    //-------------------------------------------------------------------

    fun addBook(ID: Int, name: String, author: String, cat: MutableMap<String, Int>) {
        var data = Books(name, author, cat)
        if (ID !in book.keys) {
            book.put(ID, data)
            println("hey,Your new book is added successfully")
            println(
                "ID          :$ID \n" +
                        "Book Name   :${data.bookName} \n" +
                        "Author Name :${data.authorName}\n" +
                        "Category    :${data.category.keys} "
            )
        } else
            println("the book with this $ID is exists")
    }

    //-------------------------------------------------------------------

    fun searchByID(id: Int) {
        if (id in book.keys) {
            println("ID          : ${id}")
            println("Book Name   : ${book.getValue(id).bookName}")
            println("Author Name : ${book.getValue(id).authorName}")
            println("Category    : ${book.getValue(id).category.keys}")
            println("----------------------------------")
        } else
            println("No books with this information")


    }

    //-------------------------------------------------------------------

    fun searchByName(name: String) {
        if (checkName(name)) {
            book.forEach { entry ->
                if (entry.value.bookName == name) {
                    println("ID          : ${entry.key}")
                    println("Book Name   : ${entry.value.bookName}")
                    println("Author Name : ${entry.value.authorName}")
                    println("Category    : ${entry.value.category.keys}")
                    println("----------------------------------")
                }
            }
        }
        else
            println("this book doesn't exist")
    }

    //-------------------------------------------------------------------

    fun deleteBookByID(id: Int) {

        if (id in book.keys) {
            book.remove(id)
        } else
            println("this book doesn't exist")
    }

    //-------------------------------------------------------------------

    fun update(id: Int, updatedBook: Books) {

        book.replace(id, updatedBook)
        println("ID          : ${id}")
        println("Book Name   : ${book.getValue(id).bookName}")
        println("Author Name : ${book.getValue(id).authorName}")
        println("Category    : ${book.getValue(id).category.keys}")
        println("----------------------------------")

    }

    //-------------------------------------------------------------------

    fun checkName(name : String):Boolean{
        var checker = false
        book.forEach { entry ->
            if (entry.value.bookName == name) {
                checker = true
            }
        }
        return checker

    }

    //-------------------------------------------------------------------

    fun displayAll(){
        println("-----BOOKS-----")
        book.forEach { entry ->
                println("ID          : ${entry.key}")
                println("Book Name   : ${entry.value.bookName}")
                println("Author Name : ${entry.value.authorName}")
                println("Category    : ${entry.value.category.keys}")
                println("----------------------------------" +
                        "\n----------------------------------")

        }
    }

    //-------------------------------------------------------------------

    fun displayByCategory(cat: MutableMap<String,Int>){

        book.forEach { entry ->
            if (entry.value.category == cat) {
                println("ID          : ${entry.key}")
                println("Book Name   : ${entry.value.bookName}")
                println("Author Name : ${entry.value.authorName}")
                println("Category    : ${entry.value.category.keys}")
                println("----------------------------------")
            }
        }
    }
}