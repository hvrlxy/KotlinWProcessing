abstract class Pet(var name: String)

class Cat (name: String) : Pet(name)

class Dog (name: String): Pet(name)

class Fish (name: String): Pet(name)

class Vet<T: Pet>{
	fun treat(t: T){
		println("Treat pet ${t.name}")
	}
}

class Contest<T: Pet> (var: Vet<in T>) {
	val scores: MutableMap<T, Int> = mutableMapOf() //create a map with key Pet and value is an integer

	fun addScore(t: T, score: Int = 0){
		if (score >= 0) scores.put(t, score) //put the contestant and its score into the mutable map that we have created
	}

	fun getWinners(): MutableSet<T> { //return a mutable set
		val highScore = scores.values.max() //get the highest value in the map
		val winners: MutableSet<T> = mutableSetOf()

		for ((t, score) in scores){
			if (score == highScore) winners.add(t)
		}

		return (winners)
	}
}

interface Retailer <out T> { //use out to make a generic type covariant (meaning that you can use a supertype in place of a subtype)
	fun sell() : T
}

class DogRetailer: Retailer<Dog> {
	override fun sell(): Dog {
		println("Sell Dog")
		return Dog("")
	}
}


class CatRetailer: Retailer<Cat> {
	override fun sell(): Cat {
		println("Sell Cat")
		return Cat("")
	}
}


class FishRetailer: Retailer<Fish> {
	override fun sell(): Fish {
		println("Sell Fish")
		return Fish("")
	}
}



fun main (args: Array<String>){
	val catFuzz = Cat("Fuzz Lightyear")
	val catKatsu = Cat("Katsu")
	val fishFinny = Fish("Finny")

	val catVet = Vet<Cat>()
	val fishVet = Vet<Dog()
	val petVet = Vet<Pet>()

	val catContest = Contest<Cat>(catVet) //because it is a class, it has to have arguments()
	catContest.addScore(catFuzz, 50)
	catContest.addScore(catKatsu, 45)
	val topcat = catContest.getWinners().first()
	println("The winner of the cat contest is ${topcat.name}")

	val petContest = Contest<Pet>(petVet)
	petContest.addScore(catFuzz, 50)
	petContest.addScore(fishFinny, 56)
	val toppet = petContest.getWinners.first()
	println("The winner of the pet contest is ${toppet.name}")

	val fishContest = Contest<Fish>(petVet)

	val catRetailer : Retailer<Cat> = CatRetailer()
	val dogRetailer : Retailer<Dog> = DogRetailer()
	val petRetailer : Retailer<Pet> = CatRetailer()
	petRetailer.sell()
}






