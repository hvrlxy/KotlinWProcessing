// This program reads in a sentence and test if it is a pangram
// pangram: contains every letters in the alphabet

fun main(args: Array<String>){
	if (args.isEmpty()){
		println("Please provide a sentence")
	}

	var sentence = args[0] //read in the sentence
	var LetterList : MutableList<Char> = emptyList()

	for (i in sentence){
		if (i in 'a'..'z') && (i ! in LetterList){ 
			LetterList.add(i)
		}
	}

	var count = LetterList.size() //count the size of the list
	if (count == 26){
		println(LetterList.joinToString())
		println("Pangram") //if the list have 26 letters, then the sentence is a pangram
	}
	else{
		println("Not a pangram")
	}


