import domain.*

fun main(args: Array<String>) {
    val menu = Menu(arrayListOf(MenuGroup(arrayListOf(), arrayListOf(MenuItem("salad")))))

    println(menu.groups)
}
