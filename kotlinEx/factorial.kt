fun main (args:Array<String>){
	val n = args[0].toInt()
	val k = args[1].toInt()
	println("($n,$k) is ${subset(n,k)}")
}

fun subset (n: Int, k: Int): Long{
	var result = 1L
	if (k <= n/2) {
		for (i in 1..k){
			result = result * (n - i + 1) / i
		}
		return result
	}
	else{
		return subset(n, n-k)
	}
}