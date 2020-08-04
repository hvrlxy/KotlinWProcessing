fun main(args:Array<String>){
	var n = args[0].toInt()
	println("The number of grain on the given square is ${grain(n)}")
	println("The sum of grain on the chessboard is ${sumGrain(n)}")
}

fun grain(n: Int): Int{
	if (n == 1){
		return 1
	}
	else{
		return (grain(n-1)*2)
	}
}

fun sumGrain(n: Int): Int{
	if (n == 1){
		return grain(1)
	}
	else{
		return sumGrain(n-1) + grain(n)
	}
}
