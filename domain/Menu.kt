package domain

class Menu(groups: List<MenuGroup>) {
    val groups = groups

    fun findItem(name: String): MenuItem? {
        for (g in groups) {
            val item = findItemRecurse(g, name)
            if (item != null) {
                return item
            }
        }

        return null
    }

    private fun findItemRecurse(group: MenuGroup, name: String): MenuItem? {
        for (i in group.items) {
            if (name == i.name) {
                return i
            }
        }

        for (sg in group.subgroups) {
            val item = findItemRecurse(sg, name)
            if (item != null) {
                return item
            }
        }

        return null
    }
}