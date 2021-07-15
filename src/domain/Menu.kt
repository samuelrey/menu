package src.domain

class Menu(groups: List<MenuGroup>) {
    val groups = groups

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