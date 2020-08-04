var astring = ""
fun main (args: Array<String>){
	astring = args[0]

	var space = " "

	val words = astring.split(space)

	println(words)
}