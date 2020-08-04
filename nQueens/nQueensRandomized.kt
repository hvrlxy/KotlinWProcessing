/*
 * File: nQueensRandomized.kt
 * Purpose: Solves the n-queens puzzle.
 * Compilation: kotlinc -cp .:stdlib.jar nQueensRandomized.kt
 * Execution: kotlin -cp .:stdlib.jar NQueensRandomizedKt n
 *   where n is a positive integer
 * Required File: StdDraw.class, queen.png
 * Author: San Skulrattanakulchai
 */

import kotlin.math.abs
import StdDraw.*

fun main(args: Array<String>) {

    fun swap(a: IntArray, i: Int, j: Int) {
        val tmp = a[i]
        a[i] = a[j]
        a[j] = tmp
    }

    fun queen(size: Int) {
        val pi = IntArray(size) { it }

        fun printBoard() {
            val DARK = java.awt.Color(244, 146, 66)
            setScale(0.0, 2.0*size)
            setPenColor(DARK)
            for (i in 0 until size) {
                for (j in 0 until size)
                    if ((i+j) % 2 == 0)
                        filledSquare(2*i+1.0, 2*j+1.0, 1.0)
                picture(2*i+1.0, 2*pi[i]+1.0, "queen.png", 1.9, 1.9)
            }
        }

        // Assume each row k = 0, 1, ..., i-1 has a queen on (k,pi[k]).
        // Returns true iff placing another queen at (i,j) is compatible with
        // the queens already placed at (k, pi[k]) for all k = 0,1,...,i-1.
        fun isCompat(i: Int, j: Int): Boolean {
            // Returns true iff the queens on (x1,y1) and (x2,y2) are attacking.
            fun isAttacking(x1: Int, y1: Int, x2: Int, y2: Int) =
                x1 == x2 || y1 == y2 || abs(x1-x2) == abs(y1-y2)
            for (k in 0 until i) {
                if (isAttacking(k, pi[k], i, j))
                    return false
            }
            return true
        }

        fun perm(i: Int): Boolean {
            if (i == size) {
                println("Here is one possible answer:")
                printBoard()
                return true
            } else {
                for (j in i until size) {
                    if (isCompat(i, pi[j])) {
                        swap(pi, i, j)
                        if (perm(i+1))
                            return true
                        swap(pi, i, j)
                    }
                }
                return false
            }
        }

        val randGen = java.util.Random()
        // Sampling w/o replacement to pick a random permutation of 0,...,size-1.
        for (i in size downTo 1)
            swap(pi, i-1, randGen.nextInt(i))

        if (!perm(0))
            println("There is no answer.")
    }

    queen(args[0].toInt())
}
