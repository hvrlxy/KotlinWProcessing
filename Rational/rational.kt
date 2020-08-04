class Rational (var num: Double){
    fun add(q: Rational){
        println("${num + q.num}")
    }

    fun minus(q: Rational){
        println("${num - q.num}")
    }

    fun divide(q: Rational){
        println("${num / q.num}")
    }

    fun multiply(q: Rational){
        println("${num * q.num}")
    
    fun mod(q: Rational){
        println("")
}

fun main() {
     val a = Rational(2.0)
     val b = Rational(3.0)

     a.add(b)
     a.minus(b)
}
    
