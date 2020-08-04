fun main(args:Array<String>){
	var n = args[0].toInt()
	println("The number of step to reach 1 is ${Collatz(n)}")
}

fun Collatz(n: Int): Int{
	var num = n
	var count = 0
	while (num != 1){
		if (num%2 ==0) {it / 2} else {it * 3 + 1}
		count ++
	}
	return count
}
