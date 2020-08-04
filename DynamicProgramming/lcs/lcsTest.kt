/**
 * file: lcsTest.kt
 * author: San Skulrattanakulchai
 * date: 2018-09-01
 * 
 * This program first reads two strings from standard input.
 * It then twice computes their longest common subsequence (LCS)
 * and reports the running time of each computation, the first
 * time using bottom-up DP, and the second time using memoization.
 * Here are some sample runs.
 *
 * $ kotlin LcsTestKt < example1.txt
 * Running dpLcs takes 1 ms of execution time.
 * Running memLcs takes 1 ms of execution time.
 *
 * $ kotlin LcsTestKt < example2.txt
 * Running dpLcs takes 1 ms of execution time.
 * Running memLcs takes 1 ms of execution time.
 */

fun main(args: Array<String>) {
    /* Reads strings x and y from standard input. */
    val x = readLine()!!
    val y = readLine()!!

    /* Runs bottom-up dp version of LCS and reports the running time. */
    var executionTime = kotlin.system.measureTimeMillis {
        dpLcs(x, y)
    }
    println("dpLcs takes $executionTime ms execution time.")

    /* Runs memoization version of LCS and reports the running time. */
    executionTime = kotlin.system.measureTimeMillis {
        memLcs(x, y)
    }
    println("memLcs takes $executionTime ms execution time.")
}
