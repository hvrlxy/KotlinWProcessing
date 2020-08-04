//This program takes a DNA string and turn it into an RNA string

fun main (args: Array<String>){
	var DNA = args[0]
	var RNA = ""
	for (i in DNA){ //loop through the character in DNA
		when (i){
			'G' -> RNA += 'C' //convert the character to RNA sequence
			'C' -> RNA += 'G'
			'T' -> RNA += 'A'
			'A' -> RNA += 'U'
			else -> { //if read in a weird letter, then return a message
				println ("Not a DNA string")
			 	System.exit(-1)
			 }
		}
	}
	println(RNA)
}

// You can loop through characters in a string like in Python, 
// but beware of the double quotation mark and the single quotation mark
//
// If you want to add more than one expressions inside the when condition
// you can use a block.
