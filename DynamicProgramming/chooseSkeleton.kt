import kotlin.math.min

/* Computes n choose k several ways & compares their running times. */
fun main(args: Array<String>) {
    val n = 13
    val k = 7
    //testRun("dpChooseSpace", n, k, ::dpChooseSpace)
    testRun("dpChooseRow", n, k, ::dpChooseRow)
    //testRun("dpChooseCol", n, k, ::dpChooseCol)
    //testRun("memChoose", n, k, ::memChoose)
    //testRun("naiveChoose", n, k, ::naiveChoose)
}

/* Test harness.  Calls f(n, k), then prints the result and running time. */
fun testRun(fname: String, n: Int, k: Int, f: (Int, Int) -> Int) {
    var result = 0
    val exeTime = kotlin.system.measureTimeMillis { result = f(n, k) }
    println("Running $fname($n, $k) gives $result and it takes $exeTime ms to execute.")
}

// /* Computes n choose k using the recurrence naively. */
// fun naiveChoose(n: Int, k: Int): Int {
//     // YOUR CODE GOES HERE
// }

/* Computes n choose k using bottom-up dynamic programming, filling
   the table in row-major order. */
fun dpChooseRow(n: Int, k: Int): Int {
    // YOUR CODE GOES HERE
    var opt = arrayOf<IntArray>()
    for (i in 0 .. n){
        var array = IntArray(k+1)
        for (j in 0 .. k){
            array += 0
        }
        opt += array
    }

    for (i in 0 .. n){
        opt[i][0] = 1
        opt[i][i] = 1
    }

    for (i in 2 .. k){
        for (j in 1 .. n){
            opt[i][j] = opt[i-1][j-1] + opt[i - 1][j]
        }
    }

    for (array in opt){
        for (value in array){
            print ("%3d".format(value))
        }
        println()
    }

    return opt[n][k]
}

/* Computes n choose k using bottom-up dynamic programming, filling
   the table in column-major order. */
// fun dpChooseCol(n: Int, k: Int): Int {
//     // YOUR CODE GOES HERE
// }

// /* Computes n choose k using bottom-up dynamic programming,
//    space-saving version */
// fun dpChooseSpace(n: Int, k: Int): Int {
//     // YOUR CODE GOES HERE
// }

// /* Computes n choose k using memoization. */
// fun memChoose(n: Int, k: Int): Int {
//     // YOUR CODE GOES HERE
// }
