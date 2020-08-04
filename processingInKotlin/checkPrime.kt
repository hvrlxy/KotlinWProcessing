fun main (args:Array<String>){
	n = args[0].toInt()
	for (i in 2 until n){
		if (n % i == 0){
			println("not Prime")
			return
		}
	}
	println("Prime")
}