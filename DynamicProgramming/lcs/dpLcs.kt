/**
 * file: dpLcs.kt
 * author: San Skulrattanakulchai
 * date: 2018-09-01
 * 
 * This program first reads two strings from standard input.
 * It then finds their longest common subsequence (LCS)
 * using bottom-up dynamic programming. Lastly, it reports
 * the result of the run. Here are some sample runs.
 *
 * $ kotlin DpLcsKt < example1.txt
 * x: m a r c h
 * y: a p r i l
 * LCS(x, y): a r
 *
 * $ kotlin DpLcsKt < example2.txt
 * x: d y n a m i c p r o g r a m m i n g
 * y: m e m o i z a t i o n
 * LCS(x, y): m i a i n
 */

fun main(args: Array<String>) {
    /* Reads strings x and y from standard input. */
    val x = readLine()!!
    val y = readLine()!!

    /*
     * Returns a new String with the chars in the receiver
     * interspersed with blanks.
     */
    fun String.explode() = this.toList().joinToString(separator=" ")

    /* Prints the exploded versions of x, y, and LCS(x, y). */
    println("""
        |x: ${x.explode()}
        |y: ${y.explode()}
        |LCS(x, y): ${dpLcs(x, y).explode()}
        """.trimMargin())
}

/*
 * Finds a longest common subsequence (LCS) of x and y
 * by dynamic programming.
 */
fun dpLcs(x: String, y: String): String {
    val m = x.length
    val n = y.length

    /* Creates a dp table `opt` with all entries set to 0. */
    val opt = Array<IntArray>(m+1) { IntArray(n+1) }

    /* Fills the table with values defined by the recurrence. */
    fun fillTable() {
        for (i in m-1 downTo 0) {
            for (j in n-1 downTo 0) {
                if (x[i] == y[j])
                    opt[i][j] = opt[i+1][j+1] + 1
                else
                    opt[i][j] = kotlin.math.max(opt[i][j+1], opt[i+1][j])
            }
        }
    }

    /*
     * Assuming the opt dp table has already been filled in, this
     * function will return a longest common subsequence (LCS)
     * of x and y by "pointer-tracing" the `opt` dp table.
     */
    fun lcs(): String {
        val sb = StringBuilder()
        var i = 0
        var j = 0
        while ((i < m) && (j < n)) {
            when {
                x[i] == y[j] -> {
                    sb.append(x[i])
                    i++
                    j++
                }
                opt[i+1][j] > opt[i][j+1] -> i++
                else /* opt[i+1][j] <= opt[i][j+1] */ -> j++
            }
        }
        return sb.toString()
    }

    fillTable()
    return(lcs())
}
