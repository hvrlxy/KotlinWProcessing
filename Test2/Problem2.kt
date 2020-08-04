fun main() {
     for (i in 0..10){
        println("f($i) = ${function(i)}")
    }
}

fun function(i: Int): Int{
    val table = IntArray(i + 1){0}
    
    for (j in 0 until table.size){
        if (j in 0..2){
            table[j] = j
        }
        else if (j % 2 == 0){
            table[j] = table[j - 3] + kotlin.math.min(table[j - 2], table[j - 1])
        }
        else{
            table[j] = table[j - 3] + kotlin.math.max(table[j - 2], table[j - 1])
        }
    }

    return table[i]
}
