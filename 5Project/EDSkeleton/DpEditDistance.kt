/**
 * file: DpEditDistance.kt
 * author: HA LE
 *
 * This program reads from standard input two strings, then computes
 * and prints their edit distance using bottom-up Dynamic Programming.
 * It will also recover and print out the optimal alignment along with
 * the individual penalties.  Here is a sample run of the program.
 *
 * $ kotlin DpEditDistanceKt < data/example10.txt
 * Edit distance = 7
 * A T 1
 * A A 0
 * C - 2
 * A A 0
 * G G 0
 * T G 1
 * T T 0
 * A - 2
 * C C 0
 * C A 1
 */

import kotlin.math.min

fun main(args: Array<String>) {
    val x = readLine()!!
    val y = readLine()!!
    println(dpEditDistance(x, y))
}

fun dpEditDistance(x: String, y: String){
    // YOUR CODE GOES HERE
    val M = x.length
    val N = y.length

    var opt = arrayOf<Array<Int>>()

    for (i in 0..M){
    	var array = arrayOf<Int>()
    	for (j in 0..N){
    		array += 0
    	}
    	opt += array
    }

    for (i in 0..M){
    	for (j in 0..N){
    		opt[M][j]= 2*(N - j)
    		opt[i][N]= 2*(M - i)
    	}
    }

    for (i in M - 1 downTo 0){
    	for (j in N - 1 downTo 0){
    		if (x[i] == y[j]){
    			opt[i][j] = minOf((opt[i+1][j+1]), (opt[i+1][j]+2), (opt[i][j+1]+2))
    		}
    		else{
    			opt[i][j] = minOf((opt[i+1][j+1] + 1), (opt[i+1][j]+2), (opt[i][j+1]+2))
    		}
    	}
    }
    
    fun printtable(){
        println("Edit Distance : ${opt[0][0]}")
        var i = 0
        var j = 0
        var cost = 0
        var xString = x[i].toString()
        var yString = y[j].toString()
        while ((i != M) && (j != N)){
            if (opt[i][j] == opt[i+1][j] + 2){
                cost = 2
                xString = x[i].toString()
                yString = "-"
                i++
            }
            else if (opt[i][j] == opt[i][j+1] + 2){
                cost = 2
                xString = "-"
                yString = y[j].toString()
                j++
            }
            else if (opt[i][j] == opt[i+1][j+1]){
                cost = 0
                xString = x[i].toString()
                yString = y[j].toString()
                i++
                j++
            }
            else if (opt[i][j] == opt[i+1][j+1] + 1){
                cost = 1
                xString = x[i].toString()
                yString = y[j].toString()
                i++
                j++
            }
            println("%3s %3s %3d".format(xString, yString, cost))
        }
    }
    printtable()
}











