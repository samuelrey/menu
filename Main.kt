import domain.*

fun main(args: Array<String>) {
    val menu = Menu(arrayListOf(MenuGroup(arrayListOf(), arrayListOf(MenuItem("salad")))))

    println(menu.groups)
    println(menu.findItem("salad"))
    println(menu.findItem("sandwich"))
    println(editDistance("salad", "dalas", 5, 5))
}

fun min(x: Int, y: Int, z: Int): Int {
    if (x <= y && x <= z)
        return x

    if (y <= x && y <= z)
        return y

    return z
}

fun editDistance(a: String, b: String, m: Int, n: Int): Int {
    if (m == 0)
        return n

    if (n == 0)
        return m

    if (a[m-1] == b[n-1])
        return editDistance(a, b, m - 1, n - 1)

    return 1 + min(
        editDistance(a, b, m, n - 1),
        editDistance(a, b, m - 1, n),
        editDistance(a, b, m - 1, n - 1)
    )
}