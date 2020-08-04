data class Recipe (val title: String, val isVegetarian: Boolean)

fun main (args: Array<String>){
	val r1 = Recipe("Thai Curry", false)
	val r2 = Recipe("Thai Curry", false)
	val r3 = r1.copy(title = "Chicken Bhuna")

	println("r1 hash code: ${r1.hashcode()}")
	println("r2 hash code: ${r2.hashcode()}")
	println("r3 hash code: ${r3.hashcode()}")

	println("r1 == r2? ${r1 == r2}")
	println("r1 == r3? ${r1 == r3}")
	println("r1 === r2? ${r1 ===r2}")
	val (title, vegetarian) = r1
	println ("title is $title and vegetarian is $vegetarian")
}