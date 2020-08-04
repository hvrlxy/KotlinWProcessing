fun main(args:Array<String>){
	var n = args[0]
	var size = args[1]
	var max = 0
	for (i in 0 until (n.length - size.toInt())){
		var product = 1
		var subString =  n.slice(i until (i+size.toInt()))
		for (j in 0 until subString.length){
			product = product * (subString[j].toString().toInt())
		}
		if (product>max){
			max = product
		}
	}
	println(max)
}
// This problem shows that the value you get when convert Char to Int is// different than when you convert String to Int						 
