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

    val distanceByItem = mg.findAllItemDistances("dallas")
    println(distanceByItem.entries)
}
