data class Recipe (var name: String)

fun main(args: Array<String>){
	var mShopping = mutableListOf("Tea", "Eggs","Milk")
	println("mShoppingList orginal: $mShopping")
	var extraShopping = listOf("Cookies", "Sugar","Eggs")
	println("mShoppingList items added: $mShopping")
	mShopping.addAll(extraShopping)
	if (mShopping.contains("Tea")){
		mShopping.set(mShopping.indexOf("Tea"), "Coffee")
	}
	mShopping.sort()
	println("mShoppingList sorted: $mShopping")
	mShopping.reverse()
	println("mShoppingList reversed: $mShopping")
//set
	val mShoppingSet = mShopping.toMutableSet()
	println("mShoppingSet is $mShoppingSet")
	val moreShopping = setOf("Chives", "Spinach", "Milk")
	mShoppingSet.addAll(moreShopping)
	println("mShoppingSet added: $mShoppingSet")
	mShopping = mShoppingSet.toMutableList()
	println("My new Shopping list: $mShopping")
//map
	val r1 = Recipe("Chicken Soup")
	val r2 = Recipe("Quinoa Salad")
	val r3 = Recipe("Thai Curry")
	val r4 = Recipe("Jambalaya")
	val r5 = Recipe("Sausage Roll")
	val mRecipeMap = mapOf("Recipe1" to r1, "Recipe2" to r2, "Recipe3" to r3)
	println("mRecipeMap original: $mRecipeMap")
	val recipesToAdd = mapOf("Recipe4" to r4, "Recipe5" to r5)
	mRecipeMap.putAll(recipesToAdd)
	println("mRecipeMap update: $mRecipeMap")
	if(mRecipeMap.containsKey("Recipe1")){
		println("Recipe1 is ${mRecipeMap.getValue("Recipe1")}")
	}
}