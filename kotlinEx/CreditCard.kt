fun main(args:Array<String>){
	var n = args.joinToString()
	var len = n.length
	var acc = 0
	for (i in 0..len-1){
		if (i%2 == 0){
			var evenNum = (n[i].toInt())*2
			if (evenNum >9){
				evenNum -= 9
			}
			acc += evenNum
		}
		else{
			var oddNum = (n[i].toInt())
			acc += oddNum
		}
	}
		
	if(acc%10 ==0){
		println("Valid")
	}
	else{
		println("Invalid")
	}
 }
		
