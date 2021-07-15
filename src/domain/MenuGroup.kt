package src.domain

class MenuGroup(private val subgroups: List<MenuGroup>, private val items: List<MenuItem>) {
    fun findItem(target: String): MenuItem? {
        for (i in items) {
            if (target == i.name) {
                return i
            }
        }

        for (sg in subgroups) {
            val item = sg.findItem(target)
            if (item != null) {
                return item
            }
        }

        return null
    }
}
