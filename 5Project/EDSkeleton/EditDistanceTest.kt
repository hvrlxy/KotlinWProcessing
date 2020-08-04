/**
 * file: EditDistanceTest.kt
 * author: San Skulrattanakulchai
 * date: 2018-09-01
 * 
 * This program first reads two strings from standard input.
 * It then twice computes their edit distance and reports
 * the running time of each computation, the first time using
 * bottom-up DP, and the second time using memoization. Here
 * are some sample runs.
 *
 * $ kotlin EditDistanceTestKt < example1.txt
 * Running dpEditDistance takes 1 ms of execution time.
 * Running memEditDistance takes 1 ms of execution time.
 *
 * $ kotlin EditDistanceTestKt < example2.txt
 * Running dpEditDistance takes 1 ms of execution time.
 * Running memEditDistance takes 1 ms of execution time.
 */

fun main(args: Array<String>) {
    /* Reads strings x and y from standard input. */
    val x = readLine()!!
    val y = readLine()!!

    /*
     * Runs bottom-up dp version of edit distance computation
     * and reports the running time.
     */
    var executionTime = kotlin.system.measureTimeMillis {
        dpEditDistance(x, y)
    }
    println("dpEditDistance takes $executionTime ms of execution time.")

    /*
     * Runs memoization version of edit distance computation
     * and reports the running time.
     */
    executionTime = kotlin.system.measureTimeMillis {
        memEditDistance(x, y)
    }
    println("memEditDistance takes $executionTime ms of execution time.")
}

