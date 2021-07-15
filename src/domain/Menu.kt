package src.domain

class Menu(private val groups: List<MenuGroup>) {
    fun findItem(target: String): MenuItem? {
        for (g in groups) {
            val item = g.findItem(target)
            if (item != null) {
                return item
            }
        }

        return null
    }
}