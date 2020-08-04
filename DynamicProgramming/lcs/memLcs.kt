/**
 * file: memLcs.kt
 * author: San Skulrattanakulchai
 * date: 2018-09-01
 * 
 * This program first reads two strings from standard input.
 * It then finds their longest common subsequence (LCS)
 * using memoization.  Lastly, it reports the result
 * of the run.  Here are some sample runs.
 *
 * $ kotlin MemLcsKt < example1.txt
 * x: m a r c h
 * y: a p r i l
 * LCS(x, y): a r
 *
 * $ kotlin MemLcsKt < example2.txt
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
        |LCS(x, y): ${memLcs(x, y).explode()}
        """.trimMargin())
}

/* Finds a longest common subsequence (LCS) of x and y by memoization. */
const val UNKNOWN = -1
fun memLcs(x: String, y: String): String {
    val m = x.length
    val n = y.length

    /* Creates a memoized table `opt` and initialize it. */
    val opt = Array<IntArray>(m+1) {
        i -> IntArray(n+1) {
            j -> when {
                i == m -> 0
                j == n -> 0
                else -> UNKNOWN
            }
        }
    }

    /* Use this function **whenever you want to read opt[i][j]**. */
    fun accessTable(i: Int, j: Int): Int {
        if (opt[i][j] == UNKNOWN) {
            opt[i][j] = if (x[i] == y[j])
                accessTable(i+1, j+1) + 1
            else
                kotlin.math.max(accessTable(i, j+1), accessTable(i+1, j))
        }
        return opt[i][j]
    }

    /*
     * Returns a longest common subsequence (LCS) of x and y.
     */
    fun lcs(): String {
        accessTable(0, 0)
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
                accessTable(i+1, j) > accessTable(i, j+1) -> i++
                else /* accessTable(i+1, j) <= accessTable(i, j+1) */ -> j++
            }
        }
        return sb.toString()
    }

    return lcs()
}
