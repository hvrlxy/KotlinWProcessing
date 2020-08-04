import kotlin.math.*

fun main (args:Array<String>){

	var max = args[0].toInt()
	var min = args[0].toInt()
	var sum = 0.0

	for (i in 0 until args.size){
		val a = args[i].toInt()
		max = max(a,max)
		min = min(a, min)
		sum += a
	}

	val average = sum/args.size

	println("range = $min..$max")
	println("average = $average")
}