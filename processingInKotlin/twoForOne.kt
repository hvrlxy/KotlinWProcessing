var n = ""

fun main (args: Array<String>){
	if (args.isEmpty()){
		println("One for you, one for me")
	}
	else{
		n = args[0]
		println("One for $n, one for me.")
	}
}