 /*
  * 3-In-A-Row Solver
  *
  * file: TiarSolverText.kt
  * Project 5 : Kotlin
  *
  * @author: Wenlei Yu
  */

fun main(args: Array<String>) {
    val puzzle = Board(args[0])
    if (solve(puzzle,puzzle.nextCall())){
	puzzle.show()
    }
    else 
	println("\nThere is no solution.")
}

fun solve(puzzle: Board, param: Pair<Int,Int>): Boolean{
	var i = param.first
	var j = param.second
	if (param == (-1 to -1)) return true

	puzzle.ChangeToBlue(i,j)
	if (puzzle.isValidBoard() && puzzle.isThreeColor()){
		val nextSquare = puzzle.nextCall()
		if (solve(puzzle,nextSquare)) {
			return true
		}
		else{
			puzzle.ChangeToBlank(i,j)
		}
	}

	puzzle.ChangeToWhite(i,j)
	if (puzzle.isValidBoard() && puzzle.isThreeColor()){
		val nextSquare = puzzle.nextCall()
		if (solve(puzzle,nextSquare)){
			return true
		}
		else{
			puzzle.ChangeToBlank(i,j)
		}
	}

	puzzle.ChangeToBlank(i,j)

	return false
}

class Board(filename: String){
	val board = mutableListOf<CharArray>()
	var size:Int = 0

	init{
		val file = java.io.FileReader(filename)
		val scanner = java.util.Scanner(file)
		size = scanner.nextInt()
		for (i in 0 until size){
			val line = scanner.next()
			board.add(line.toCharArray())
		}
	}

    override fun toString(): String {
        return board.joinToString(
                separator = "\n",
                transform = { it.joinToString(separator = "") }
        )
    }
	
	fun show() = println(this)

	// check each row and column have an equal number ot white and blue
	fun isValidBoard():Boolean{
		// Go through row, and check if not too many blues/white
		for (i in 0 until size){
			val row = board[i]
			if (row.count{it=='B'}>size/2) return false
			if (row.count{it=='W'}>size/2) return false
		}
		// Go through column, and check if not too many blues/white
		for (j in 0 until size){
			var number_blue = 0
			var number_white = 0
			for (i in 0 until size){
				var column = board[i][j]
				if (column=='B'){
					number_blue += 1
				}
				if (number_blue > size/2) return false
				if (column=='W'){
					number_white += 1
				}
				if (number_white > size/2) return false
			}
		}
		return true
	}

	// check each row and column have no three same color together 
	fun isThreeColor():Boolean{
		// Go through row, and check if not three blues/white together
		for (i in 0 until size){
			for (j in 0 until size-2){
				if ((board[i][j] == 'B' || board[i][j] == 'W') && board[i][j] == board[i][j+1] && board[i][j] == board[i][j+2]) return false		
			}
		}
		// Go through column, and check if not three blues/white together
		for (j in 0 until size){
			for (i in 0 until size-2){
				if ((board[i][j] == 'B' || board[i][j] == 'W') && board[i][j] == board[i+1][j] && board[i][j] == board[i+2][j]) return false
			}
		}
		return true
	}

	// change to blue
	fun ChangeToBlue(i:Int,j:Int) {board[i][j] = 'B'}
	
	// change to white
	fun ChangeToWhite(i:Int,j:Int) {board[i][j] = 'W'}

	// change to blank
	fun ChangeToBlank(i:Int,j:Int) {board[i][j] = '-'}

	// loop throught the board and find the next empty blank
	// if cannot find it, then return (-1, -1)
	fun nextCall():Pair<Int,Int>{
		for (i in 0 until size){
			for (j in 0 until size){
				if (board[i][j] == '-') return (i to j)
			}
		}
		return (-1 to -1)
	}
}