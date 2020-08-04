import kotlin.random.*

var options = arrayOf("rock", "paper", "scissors")
var result = ""

fun main (args:Array<String>){
	var i = getGameChoice(options)
	var you = getUserChoice()
	var resultLast = getResult(i,you)

	println("You choose $you and I choose $i. $resultLast")
}

fun getGameChoice (args: Array<String>): String{
	var a = Random.nextInt(3)
	return args[a]
}

fun getUserChoice() : String{
	var validChoice = false
	var userChoice = ""
	while (validChoice == false){
		println("Please choose between rock, paper and scissors ")
		userChoice = readLine().toString()
		validChoice = isChoiceValid(userChoice.toString())
		if (validChoice == false){
			println("You must enter a valid choice")
		}

		else{
			userChoice = userChoice
		}
	}

	return userChoice.toString()
}

fun getResult(i: String, you: String): String{
	if ((i == "rock" && you == "scissors") || (i == "scissors" && you == "paper") || (i == "paper" && you == "rock")){
		result = " I win! \nGood luck next time!!!"
	}

	else if (i == you){
		result = " It's a tie!"
	}

	else{
		result = " You win! \nCongratulations!!!"
	}

	return result
}

fun isChoiceValid(choice: String): Boolean{
	var isChoiceValid = false
	if (choice == "rock" || choice == "scissors" || choice == "paper"){
		isChoiceValid = true
	}

	return isChoiceValid
}