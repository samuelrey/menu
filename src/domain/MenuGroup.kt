package src.domain

class MenuGroup(subgroups: List<MenuGroup>, items: List<MenuItem>) {
    val subgroups = subgroups
    val items = items

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
