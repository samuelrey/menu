package src.domain

class Menu(private val groups: List<MenuGroup>) {
    fun findItem(name: String): MenuItem? {
        for (g in groups) {
            val item = g.findItem(name)
            if (item != null) {
                return item
            }
        }

        return null
    }
}