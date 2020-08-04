fun main(args: Array<String>){
	var n = args[0].toInt()
	var array = factor(n)
	if (array.sum()==n){
		println("Perfect")
	}
	else if (array.sum() > n){
		println("Abundant")
	}
	else{
		println("Deficient")
	}
	return 
}

fun factor(n: Int): Array<Int>{
	var aList = Array<Int>(n){0}
	for (i in 1 until n){
		if (n%i == 0){
			aList[i] = i
		}
	}
	return aList
} 
		

		
	
