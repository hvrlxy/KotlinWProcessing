open class Animals { //it's a superclass so we need to delare it open
	open val image = ""
	open val food = ""
	open val habitat = ""
	val hunger = 10 //we are not going to override this properties

	open fun makeNoise(){
		println("The Animals is making a noise")
	}

	open fun eat(){
		println("The Animals is eating")
	}

	open fun roam(){
		println("The Animals is roaming")
	}

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

open class Canine: Animals(){
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
	val animals = arrayOf(Hippo(), Wolf())
	for (i in animals){
		i.makeNoise()
		i.eat()
	}

	val vet = Vet()
	val wolf = Wolf()
	val hippo = Hippo()
	vet.giveShot(wolf)
	vet.giveShot(hippo)
}











