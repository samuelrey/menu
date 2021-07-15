import src.domain.*

fun main(args: Array<String>) {
    // TODO fetch menu from database
    val menu = Menu(arrayListOf(MenuGroup(arrayListOf(), arrayListOf(MenuItem("salad")))))

    // TODO move into tests
    var item = menu.findItem("salad")
    if (item == null)
        println("Item should not be null")

    item = menu.findItem("sandwich")
    if (item != null)
        println("Item should be null")
}
