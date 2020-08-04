fun main (args: Array<String>){

	if (args.size != 1){
		println("Please provide a valid positive integer.")
		System.exit(-1)
	}

	var n = args[0].toInt()

	if (n < 1){
		println("Please provide a valid positive integer.")
		System.exit(-1)
	}

	var count = 0
	for (i in 1..n){
		if (n%i == 0){
			count = count + 1
		}
	}

	println(count)
}