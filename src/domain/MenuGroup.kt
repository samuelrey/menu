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

    fun findAllItemDistances(target: String): Map<MenuItem, Int> {
        val out = hashMapOf<MenuItem, Int>()
        for (i in items)
            out[i] = i.EditDistance(target)

        // Stitch together the item edit distances from subgroups.
        for (sg in subgroups) {
            val new = findAllItemDistances(target)
            out += new
        }

        return out
    }
}
