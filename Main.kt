fun main(args: Array<String>) {
    val menu = Menu(arrayListOf(MenuGroup(arrayListOf(), arrayListOf(MenuItem("salad")))))
    
    println(menu)
}

data class MenuItem(val name: String)

data class MenuGroup(val subgroups: List<MenuGroup>, val items: List<MenuItem>)

data class Menu(val groups: List<MenuGroup>)