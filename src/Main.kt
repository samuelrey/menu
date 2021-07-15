import src.domain.*

fun main(args: Array<String>) {
    val menu = Menu(arrayListOf(MenuGroup(arrayListOf(), arrayListOf(MenuItem("salad")))))

    var memo = arrayOf<Array<Int>>()
    for (i in 0..6) {
        var row = arrayOf<Int>()
        for (j in 0..6) {
            row += -1
        }
        memo += row
    }
    println(editDistance("salad", "xxxxx", 5, 5, memo))
}

fun min(x: Int, y: Int, z: Int): Int {
    if (x <= y && x <= z)
        return x

    if (y <= x && y <= z)
        return y

    return z
}

fun editDistance(a: String, b: String, m: Int, n: Int, memo: Array<Array<Int>>): Int {
    if (m == 0)
        return n

    if (n == 0)
        return m

    if (memo[m][n] != -1)
        return memo[m][n]

    if (a[m-1] == b[n-1]) {
        if (memo[m-1][n-1] != -1) {
            memo[m][n] = memo[m-1][n-1]
            return memo[m][n]
        }
        else {
            memo[m][n] = editDistance(a, b, m - 1, n - 1, memo)
            return memo[m][n]
        }
    }

    val x: Int
    if (memo[m][n-1] != -1)
        x = memo[m][n-1]
    else
        x = editDistance(a, b, m, n - 1, memo) 

    val y: Int
    if (memo[m-1][n] != -1)
        y = memo[m-1][n]
    else
        y = editDistance(a, b, m - 1, n, memo) 

    val z: Int
    if (memo[m-1][n-1] != -1)
        z = memo[m-1][n-1]
    else
        z = editDistance(a, b, m - 1, n - 1, memo) 

    memo[m][n] = 1 + min(x, y, z)
    return memo[m][n]
}