interface Roamable {
	/* Use an interface to declare public functions
	You can override EVERYTHING in the interface 
	An interface CANNOT inherit from the superclass, but it 
	can implement from other interface (interface A: B,C) */
	// you dont need to declare a function as abstract inside an interface
	fun roam()

	//interface does not have a backing field so you can use field inside set()

}

class Vehicle: Roamable { //interface does not have any parameter
	override fun roam(){
		println("The Vehicle is roaming!")
	}
}

/* concrete class have to override all the abstract function from the interface
and the superclasses */

abstract class Animals: Roamable { //declare a class abstract means that we cannot create an Animal object

	/* if you want to mark a function or a property to be abstract
	the class have to be abstract too */

	abstract val image: String //abstract properties dont have to be marked as open
	abstract val food: String  //abstract properties dont have to be initialized
	abstract val habitat: String
	val hunger = 10 //we are not going to override this properties

	/* abstract functions do NOT need a body so NO CURLY BLOCKS */
	abstract fun makeNoise() 

}
	abstract fun eat()

	override fun roam()

	fun sleep(){  //not gonna override this funtion
		println("The Animals is sleeping")
	}
}

class Hippo : Animals(){
	override val image = "hippo.jpg" //if used val in superclass then have to override
	override val food = "grass"		 //if used var in superclass, then use init{ var = }
	override val habitat = "water"

	override fun makeNoise(){		 //parameter in override function must match the one
		println("Grunt!")			 //in the superclass and the return type have to be compatible
	}

	override fun eat(){
		println("The Hippo is eating $food")
	}
}

abstract class Canine: Animals(){
	override fun roam(){
		println("The Canine is roaming")
	}
}

class Wolf: Canine(){
	override val image = "wolf.jpg"
	override val food = "meat"
	override val habitat = "forests"

	override fun makeNoise(){
		println("Hoooooooowl!")
	}

	override fun eat(){
		println("The wolf is eating $food")
	}
}

class Vet {
	fun giveShot(animal: Animals){
		animal.makeNoise()
	}
}

fun main (args: Array<String>){
	val roamables = arrayOf(Hippo(), Wolf())
	for (i in animals){
		i.makeNoise()
		i.eat()
	}

	val vet = Vet()
	val wolf = Wolf()
	val hippo = Hippo()
	vet.giveShot(wolf)
	vet.giveShot(hippo)

	when (i in roamables){
		is Wolf -> { //is is used as a smart cast to a Wolf a a duration of this block of codes
			roamable.eat()
		}
		is Hippo -> {
			roamable.roam()
		}
		is Animals -> {
			roamable.sleep()
		}
	}
}











