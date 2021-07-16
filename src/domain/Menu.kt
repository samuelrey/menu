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

    fun findClosestItems(target: String, n: Int): List<MenuItem> {
        if (n < 1)
            return arrayListOf()

        // start by calculating the distance of the target string to each of the menu items.
        val distanceByItem = hashMapOf<MenuItem, Int>()
        for (g in groups) {
            val new = g.findAllItemDistances(target)
            distanceByItem += new
        }

        // invert the keys and values in order to sort by distance.
        val itemByDistance = hashMapOf<Int, MutableList<MenuItem>>()
        for ((item, distance) in distanceByItem) {
            val items = itemByDistance.getOrDefault(distance, arrayListOf())
            items += item
            itemByDistance[distance] = items
        }

        val distances = itemByDistance.keys.toMutableList()
        distances.sort()

        // fill the output list with menu items that have the smallest distance to the target.
        val out = arrayListOf<MenuItem>()
        var i = 0
        var items = itemByDistance.getOrDefault(distances[i], arrayListOf())
        while (out.size < n) {
            if (items.size == 0) {
                i++
                if (i < distances.size) {
                    items = itemByDistance.getOrDefault(distances[i], arrayListOf())
                } else {
                    break
                }
            }

            out += items[0]
            items.removeAt(0)
        }

        return out
    }
}