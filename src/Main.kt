import src.domain.*

fun main(args: Array<String>) {
    // TODO fetch menu from database
    val mi = arrayListOf(MenuItem("salad"), MenuItem("burger"), MenuItem("dallas"))
    val mg = MenuGroup(arrayListOf(), mi)
    val menu = Menu(arrayListOf(mg))

    // TODO move into tests
    var item = menu.findItem("salad")
    if (item == null)
        println("Item should not be null")

    item = menu.findItem("sandwich")
    if (item != null)
        println("Item should be null")

    var ci = menu.findClosestItems("filet mignon", 1)
    if (ci.size != 1)
        println("There should be one item")

    ci = menu.findClosestItems("turkey burger", 2)
    if (ci.size != 2)
        println("There should be two items")

    ci = menu.findClosestItems("dalas", 0)
    if (ci.isNotEmpty())
        println("There shouldn't be any items")

    ci = menu.findClosestItems("dalas", 7)
    if (ci.size != 3)
        println("There should be 3 items")
}
