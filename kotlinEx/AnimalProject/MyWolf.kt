class Wolf{
	val image = "wolf.jpg"
	val food = "meat"
	var hunger = 10

	fun makeNoise(){
		println("Hoooooooowl!")
	}

	fun eat(){
		println("The wolf is eating $food")
	}
}

//null points

class MyWolf(){
	var wolf: Wolf? = Wolf() // this variable can be a wolf or a null

	fun myFunction(){
		wolf?.eat()
	}

	fun getAlphaWolf(): Wolf?{
		return Wolf()
	}
}

fun main(args: Array<String>){
	var w: Wolf? = Wolf()
	if (w != null){
		w.eat()
	}
	var x = w?.hunger
	println("The value of x is $x")
	var y = w?.hunger ?: -1
	println("The value of y is $y")

	var myWolf = MyWolf()
	myWolf.wolf?.hunger = 8
	println("The value of myWolf?.wolf?.hunger is ${myWolf?.wolf?.hunger}")

	/*
	SAFE CALL */
	//safe call
	//w?.eat() // check whether if w is null, if it is not then perform the function
	//w?.hunger()

	/* CHAIN NULL */
	//println("The wolf hungry level is  ${MyWolf?.w?.hunger}" // if myWolf and w is not null, then return hunger
	//var x = w?.hunger //if w is null, then x is null, otherwise return the hunger level of w
	//MyWolf?.w?.hunger = 6 //assign values to chain safe call
	//w?.let{
	//	println(${it.hunger}) //use let to replace the if statement
	//}

	/* you can use an Elvis expression in place of the if statement*/
	//w?.hunger ?: 1 // meaning if w is not null, and if its hunger is not null, then set it to 1
	// the if statement will be if (w?.hunger != null) w.hunger else -1
	var myArray = arrayOf("Hi", "Hello", null)
	for (i in myArray){
		i?.let{println(it)}
	}

	/* we can also use let to stream line expression, such as*/
	//getAlphaWolf()?.let{ // this means that get an alpha wolf, if it is not null, let it eat
	//	it.eat()		 // you dont have to declare another alpha wolf var if using let, because
	//}					 // the 'it' already means that

	/* the double exclamation !! will throw a NullPointException error if it see a null value */
	//w = null
	//var z = w!!.hunger

}






