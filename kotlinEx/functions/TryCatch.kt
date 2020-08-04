fun main (args:Array<String>){
	try {
		var x = args[0].toInt()

		if (x !in 0..100){
			throw IllegalArgumentException("not in the range")
		}
		else{
			println(x)
		}
	}
	catch (e: IllegalArgumentException){ //this get executed when an exception is made
		println("Bummer")
	}

	finally{						  //run no matter what
		println("My function has end")
	}
}

/* YOU CANNOT

- have a catch or a finally without a try
- put codes between a try and a catch
- A try must be followed by a catch or a finally
- A try can have multiple catch

*/