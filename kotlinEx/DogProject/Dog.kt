class Dog (val name: String,
	weight_param: Int,
	breed_param: String){

	init {
		println("Dog $name has been created")
	}

	var activity = arrayOf("Walks")
	val breed = breed_param.toUpperCase()

	init {
		println("The breed is $breed")
	}

	var weight = weight_param
		set (value) {
			if (value > 0) field = value
		}

	val weightInKgs: Double
		get() = weight / 2.2

	fun bark(){
		println(if (weight > 20) "Yip!" else "Woof!")
	}
}

fun main(args:Array<String>) {
	val myDog = Dog("Smiley", 70, "Husky")
	myDog.bark()
	println("My dog weight in kgs is ${myDog.weightInKgs}")
	myDog.weight = 75
	println("My dog weight is ${myDog.weight}")
	myDog.activity = arrayOf("Walking", "Barking", "Fetching")
	for (i in 0 until (myDog.activity).size){
		println("My dog enjoys ${myDog.activity[i]}")
	}

	val dogs = arrayOf(Dog("Kelpie",20,""), Dog("Ripper",10,"Poodle"))
	dogs[1].bark()
	println("${dogs[1].name}'s weight is ${dogs[1].weightInKgs}")
}