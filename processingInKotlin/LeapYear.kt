var n = 0

fun main (args: Array<String>){
	if (args.isEmpty()){
		println("Please provide a year")
	}
	else{
		n = args[0].toInt()
		when{
			n%400 == 0 -> println("Leap Year")
			n%100 == 0 -> println("Not Leap Year")
			n%4 == 0 -> println("Leap Year")
			else -> println("Not Leap Year")
		}
	}
}