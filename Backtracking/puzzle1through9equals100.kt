/*
 * file: puzzle1through9equals100.kt
 * date: Oct 18, 2019
 * author: SS
 */

/**
 * This program outputs all possibilities to put + or - or nothing
 * between the numbers 1,2,...,9 (in this order) such that the result
 * is 100. For example 1 + 2 + 3 - 4 + 5 + 6 + 78 + 9 = 100.
 */

const val TARGET = 100
const val MAX_DIGIT = 9

val exp = mutableListOf<String>()

fun main() {
    var tryAmount = 1
    var nextDigit = 2

    // We'll do an exhaustive search.
    // For the particular problem of TARGET = 100 and MAX_DIGIT = 9,
    // we can replace MAX_DIGIT on the next line by 5.
    while (nextDigit <= MAX_DIGIT) {
        exp.add("$tryAmount")
        search(tryAmount, nextDigit)
        exp.removeAt(0)
        tryAmount = 10 * tryAmount + nextDigit
        ++nextDigit
    }
}

fun search(partial: Int, nxtDigit: Int) {
    if (nxtDigit > MAX_DIGIT) {
        if (partial == TARGET)
            println(exp.joinToString(separator = " "))
        return
    } else {
        var tryAmount = nxtDigit
        var nextDigit = nxtDigit
        while (nextDigit <= MAX_DIGIT) {
            ++nextDigit
            tryPlus(partial, tryAmount, nextDigit)
            tryMinus(partial, tryAmount, nextDigit)
            tryAmount = 10 * tryAmount + nextDigit
        }
    }
}

fun tryPlus(partial: Int, tryAmount: Int, nextDigit: Int) {
    exp.add("+")
    exp.add("$tryAmount")
    search(partial + tryAmount, nextDigit)
    exp.removeAt(exp.lastIndex)
    exp.removeAt(exp.lastIndex)
}

fun tryMinus(partial: Int, tryAmount: Int, nextDigit: Int) {
    exp.add("-")
    exp.add("$tryAmount")
    search(partial - tryAmount, nextDigit)
    exp.removeAt(exp.lastIndex)
    exp.removeAt(exp.lastIndex)
}
