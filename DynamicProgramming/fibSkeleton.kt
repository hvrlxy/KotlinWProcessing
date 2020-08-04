/* Computes the nth Fibonacci number several ways & compares their running times. */
fun main() {
    val n = 43
    testRun("dpFib", n, ::dpFib)
    testRun("memFib", n, ::memFib)
    testRun("naiveFib", n, ::naiveFib)
}

/* Test harness.  Calls f(n), then prints the result and running time. */
fun testRun(fname: String, n: Int, f: (Int) -> Int) {
    var result = 0
    val exeTime = kotlin.system.measureTimeMillis { result = f(n) }
    println("Running $fname($n) gives $result and it takes $exeTime ms to execute.")
}

/* Computes the nth Fibonacci number using the recurrence naively. */
// fun naiveFib(n: Int): Int{
//     // YOUR CODE HERE
//     if(n == 0 ){
//         return 0
//     }

//     else if (n == 1){
//         return 1
//     }

//     else{
//         return naiveFib(n - 1) + naiveFib(n - 2)
//     }
// }

/* Computes the nth Fibonacci number using bottom-up dynamic programming. */
fun dpFib(n: Int): Int {
    // YOUR CODE HERE
    var fibArray = IntArray(n) {it}
    for (i in 2 until n){
        fibArray[i] = fibArray[i - 1] + fibArray[i - 2]
    }

    return fibArray[n - 1]
}

/* Computes the nth Fibonacci number using memoization. */
fun memFib(n: Int): Int {
    // YOUR CODE HERE
    val UNKNOWN = -1
    var fibArray = IntArray(n + 1) {UNKNOWN}

    for (i in 2 .. n){
        if (fibArray[i] != UNKNOWN){
            fibArray[i] = fibArray[i]
        }
        else {
            fibArray[i] = fibArray[i - 1] + fibArray[i - 2]
        }
    }
    return fibArray[n]
}
