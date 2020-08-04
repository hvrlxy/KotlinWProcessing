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
	var sum = 0.0
	for (i in 1..n){
		if (n%i == 0){
			count ++
			sum += i 
		}
	}
	if (count == 1){
		println("$count factor\nMean: ${sum/count} ")
	}
	else{
		println("$count factors\nMean: ${sum/count} ")
	}
}