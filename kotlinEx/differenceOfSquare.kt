import kotlin.math.pow

fun main(args:Array<String>){
	var n = args[0].toInt()
	var squareSum = 0F
	for (i in 0..n){
		squareSum += i
	}
	squareSum = squareSum.pow(2F)

	var sumSquare = 0F
	for (i in 0..n){
		sumSquare += (i.toFloat()).pow(2F)
	}
	println (squareSum - sumSquare)
	return
}
