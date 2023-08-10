class CategoryList {

    // a mutable Map of category name and id
    var category: MutableMap<String, Int> = mutableMapOf()

    //-------------------------------------------------------------------

    //initialize the list by unknown and 0 values
    init {
        category["UnKnown"] = 0
    }

    //-------------------------------------------------------------------

    // Add category function
    fun addCategory(categoryName: String, categoryID: Int) {

        //check first if the values are exist or not
        if (categoryID !in category.values && categoryName !in category) {
            category[categoryName] = categoryID
            println("hey,Your new category is added successfully")
            println("$categoryID : $categoryName")
        } else
            println("$categoryID and $categoryName can't be added because it's exists")
    }

    //-------------------------------------------------------------------

    //show categories
    fun showCategory() {
        println("Category ID : Category Name")
        category.forEach { entry ->
            print("${entry.value} : ${entry.key} \n -----------------------------\n")
        }
    }

    //-------------------------------------------------------------------

    // Delete category by id function
    fun deleteCategoryByID(categoryID: Int) {

        //check first if the id is exists or not
        if (categoryID in category.values)
            category.values.remove(categoryID)
        else
            println("$categoryID doesn't exists")

    }

    //-------------------------------------------------------------------

    // Delete category by name function
    fun deleteCategoryByName(categoryName: String) {

        //check first if the value is exists or not
        if (categoryName in category)
            category.remove(categoryName)
        else
            println("$categoryName doesn't exists")

    }

    //-------------------------------------------------------------------

    //Update category
    fun updateCategory() {

        println("  UPDATE CATEGORY NAME :  ")
        println("---------------------------")
        println("Enter the value you want to update: ")
        var ID = readlnOrNull()?.toInt()
        //if id in the categories
        if (ID in category.values) {

            println("Enter the updated value that you want: ")
            var updatedValue = readlnOrNull()
            if (updatedValue != null && ID != null) {
                //if the values exist then delete it then assign the new one
                deleteCategoryByID(ID)
                category[updatedValue] = ID
            } else {
                println("WRONG VALUE!!")
                error()
            }
        } else {
            println("WRONG VALUE!!")
            error()
        }

    }

    //-------------------------------------------------------------------

    //Set category
    fun setCategory(cat: Int, catList: CategoryList) : MutableMap<String,Int>{
        var category: MutableMap<String, Int> = mutableMapOf()
        catList.category.forEach { entry ->
            if (entry.value == cat) {
                category[entry.key] = entry.value
                return category
            }
        }
        category["UnKnown"] = 0
        return category
    }

    //-------------------------------------------------------------------

    //error
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

    //-------------------------------------------------------------------
    // THE END
}