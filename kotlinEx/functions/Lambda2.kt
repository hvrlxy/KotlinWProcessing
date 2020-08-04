fun convert(x: Double, converter: (Double) -> Double) : Double{
	val result = converter(x)
	println("$x is converted into $result")
	return result
}

fun convertFive(converter: (Int) -> Double) : Double{
	val result = converter(5)
	println("5 is converted into $result")
	return result
}

fun main (args: Array<String>){
	convert(20.0) {it * 1.8 + 32}
	convertFive {it * 1.8 + 32}
}
