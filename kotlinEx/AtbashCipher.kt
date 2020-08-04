fun main(args:Array<String>){
	var word = args[0]
	var method = args[1]
	if (method == "encode"){
		println("${encode(word)}")
	}
	else if (method == "decode"){
		println("${decode(word)}")
	}
	else{
		println("Not the right command")
	}
}

val alphabet = "abcdefghijklmnopqrstuvwxyz"
val alphabetReverse = alphabet.reversed()
	 

fun encode(word: String): String{
	var result = ""
	for (i in 0 until word.length){
		var index = alphabet.indexOf(word[i])
		result += alphabetReverse[index].toString()
	}
	return result
}

fun decode(word: String): String{
	var result = ""
	for (i in 0 until word.length){
		var index = alphabetReverse.indexOf(word[i])
		result += alphabet[index].toString()
	}
	return result
}

	
