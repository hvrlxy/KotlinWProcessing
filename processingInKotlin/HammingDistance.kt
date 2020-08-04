// This program calculate the differences between two DNA strings

fun main(args:Array<String>){
	if (args.size != 2){
		println("PLease provide two DNA strands")
		System.exit(-1)
	}

	var str1 = args[0]
	var str2 = args[1]

	val len1 = str1.length
	val len2 = str2.length

	if (len1 != len2){
		println("Please provide 2 DNA strands with the same length")
		System.exit(-1)
	}

	var A1 = Array<Char>(len1){'a'}
	var A2 = Array<Char>(len2){'a'}

	for (i in 0 until len1){
		A1[i] = str1[i]
		A2[i] = str2[i]
	}

	var count = 0

	for (i in 0 until len1){
		if (A1[i] != A2[i]){
			count = count + 1
		}
	}

	println (count)
}