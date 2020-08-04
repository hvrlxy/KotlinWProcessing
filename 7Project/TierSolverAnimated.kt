import processing.core.*
import java.util.Scanner

var size = 0
var aList = mutableListOf<Triple<Int, Int, Char>>()
var squareSize = 0f

fun main(){
	val sc = Scanner(System.`in`)

	size = sc.nextInt()
	val array = Array<CharArray>(size){CharArray(size){' '}}

	for (i in 0 until size){
		val aString = sc.next()
		for (j in 0 until size){
			array[i][j] = aString[j]
			aList.add(Triple(i,j,aString[j]))
		}
	}

	fun findNext(): Pair<Int, Int>{
		for (i in 0 until size){
			for (j in 0 until size){
				if (array[i][j] == '-') return (i to j)
			}
		}

		return (-1 to -1)
	}

	fun isValid(pos: Pair<Int, Int>): Boolean{

		if (pos.first > 1 && pos.first < size - 2){
			if ((array[pos.first][pos.second] == array[pos.first + 1][pos.second] &&
				array[pos.first][pos.second] == array[pos.first - 1][pos.second]) || 
				(array[pos.first][pos.second] == array[pos.first + 1][pos.second] && 
				array[pos.first][pos.second] == array[pos.first + 2][pos.second]) ||
				(array[pos.first][pos.second] == array[pos.first - 1][pos.second] && 
				array[pos.first][pos.second] == array[pos.first - 2][pos.second])){
				return false
			}
		}

		if (pos.second > 1 && pos.second < size - 2){
			if ((array[pos.first][pos.second] == array[pos.first][pos.second + 1] && 
				array[pos.first][pos.second] == array[pos.first][pos.second - 1]) ||
				(array[pos.first][pos.second] == array[pos.first][pos.second - 1] && 
				array[pos.first][pos.second] == array[pos.first][pos.second - 2]) ||
				(array[pos.first][pos.second] == array[pos.first][pos.second + 1] && 
				array[pos.first][pos.second] == array[pos.first][pos.second + 2])){ 
				return false
			}
		}

		if (pos.first == 1 || pos.first == size - 2){
			if (array[pos.first][pos.second] == array[pos.first + 1][pos.second] && 
				array[pos.first][pos.second] == array[pos.first - 1][pos.second]){
				return false
			}
		}

		if (pos.second == 1 || pos.second == size - 2){
			if (array[pos.first][pos.second] == array[pos.first][pos.second + 1] && 
				array[pos.first][pos.second] == array[pos.first][pos.second - 1]){
				return false
			}
		}

		if (pos.first == 0 || pos.first == 1){
			if (array[pos.first][pos.second] == array[pos.first + 1][pos.second] && 
				array[pos.first][pos.second] == array[pos.first + 2][pos.second]){
				return false
			}
		}

		if (pos.first == size - 1 || pos.first == size - 2){
			if (array[pos.first][pos.second] == array[pos.first - 1][pos.second] && 
				array[pos.first][pos.second] == array[pos.first - 2][pos.second]){
				return false
			}
		}

		if (pos.second == 0 || pos.second == 1){
			if (array[pos.first][pos.second] == array[pos.first][pos.second + 1] && 
				array[pos.first][pos.second] == array[pos.first][pos.second + 2]){ 
				return false
			}
		}

		if (pos.second == size - 1 || pos.second == size - 2){
			if (array[pos.first][pos.second] == array[pos.first][pos.second - 1] && 
				array[pos.first][pos.second] == array[pos.first][pos.second - 2]){ 
				return false
			}
		}

		var d = 0

		for (i in 0 until size){
			if (array[pos.first][i] == array[pos.first][pos.second]) d ++
			if (d > size/2) return false
		}

		var c = 0

		for (i in 0 until size){
			if (array[i][pos.second] == array[pos.first][pos.second]) c ++
			if (c > size/2) return false
		}

		return true
	}

	fun tryColor(pos: Pair<Int, Int>): Boolean{
		//if this is the last cell then return true
		if (pos.first == -1) return true

		array[pos.first][pos.second] = 'W'
		aList.add(Triple(pos.first, pos.second, 'W'))
		if (isValid(pos)){
			if (tryColor(findNext())) return true
		}

		array[pos.first][pos.second] = 'B'
		aList.add(Triple(pos.first, pos.second, 'B'))
		if (isValid(pos)){
			if(tryColor(findNext())) return true
		}

		array[pos.first][pos.second] = '-'
		aList.add(Triple(pos.first, pos.second, '-'))
		return false
	}

	val source = findNext()
	if (!tryColor(source)) return println("There is no solution.")

	//println(aList)

	PApplet.main("TierSolverGraphic")
}

class TierSolverGraphic : PApplet (){
	override fun settings(){
		size(500,500)
	}

	override fun setup(){
		background(200f)
		squareSize = 500f/size
		frameRate(5f)
	}

	override fun draw(){
		val currentSquare : Triple<Int, Int, Char> = aList[0]
		aList.removeAt(0)
		if (aList.isEmpty()){
			noLoop()
		}
		if (currentSquare.third == 'W'){
			fill(255f)
			rect(currentSquare.second * squareSize, currentSquare.first * squareSize, squareSize, squareSize)
		}

		else if (currentSquare.third == 'B'){
			fill(9f, 38f, 153f)
			rect(currentSquare.second * squareSize, currentSquare.first * squareSize, squareSize, squareSize)
		}

		else if (currentSquare.third == '-'){
			fill(200f)
			rect(currentSquare.second * squareSize, currentSquare.first * squareSize, squareSize, squareSize)
		}
	}
}