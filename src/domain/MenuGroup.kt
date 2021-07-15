package src.domain

class MenuGroup(private val subgroups: List<MenuGroup>, private val items: List<MenuItem>) {
    fun findItem(name: String): MenuItem? {
        for (i in items) {
            if (name == i.name) {
                return i
            }
        }

        for (sg in subgroups) {
            val item = sg.findItem(name)
            if (item != null) {
                return item
            }
        }

        return null
    }
}
