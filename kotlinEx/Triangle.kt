fun main(args:Array<String>){
	if (args.size != 3){
		println("Not a triangle")
		System.exit(-1)
	}

	var a = args[1].toFloat()
	var b = args[0].toFloat()
	var c = args[2].toFloat()
	
	if ((a+b<c) || (a+c< b)||(c+b<a)){
		println("Not a triangle")
		System.exit(-1)
	}
	
	when{
		((a==b)&&(b==c)) -> println("Equilateral triangle")
		((a==b)||(a==c)||(b==c))-> println("Isosceles triangle")
		// ((a==b) && (b==c))-> println("Equilateral triangle")
		else -> println("Scalene triangle")	
	}
}
