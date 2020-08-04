fun main(args: Array<String>) {
    val maze = Maze(args[0])
    println("This is the maze with the starting position at S.\n")
    maze.show()
    if (solveMaze(maze, maze.startPosition)) {
        println("\nThe marked path is a solution.\n")
        maze.show()
    } else
        println("\nNo solution exists.")
}

fun solveMaze(maze: Maze, start: Point): Boolean {
    if (maze.isOutside(start)){
        return true
    }
    else if(!maze.isEmptySquare(start)){
        return false
    }

    maze.markSquare(start)
    if (solveMaze(maze, adjacentPoint(start, Direction.NORTH)) || 
        solveMaze(maze, adjacentPoint(start, Direction.WEST)) || 
        solveMaze(maze, adjacentPoint(start, Direction.EAST)) || 
        solveMaze(maze, adjacentPoint(start, Direction.SOUTH))){
        return true
    }
    maze.unmarkSquare(start)
    return false
}

fun adjacentPoint(start: Point, dir: Direction) = when (dir) {
    Direction.NORTH -> start.copy(y = start.y-1)
    Direction.EAST -> start.copy(x = start.x+1)
    Direction.SOUTH -> start.copy(y = start.y+1)
    Direction.WEST -> start.copy(x = start.x-1)
}

data class Point(val x: Int, val y: Int)

enum class Direction { NORTH, EAST, SOUTH, WEST }

class Maze(filename: String) {
    val maze = mutableListOf<CharArray>() 
    lateinit var startPosition: Point
        private set

    init {
        java.io.File(filename).useLines {
            lines ->
                lines.forEachIndexed {
                    index: Int, line: String ->
                        maze.add(line.toCharArray())
                        val positionS = line.indexOf('S')
                        if (positionS != -1)
                            startPosition = Point(positionS, index)
                }
        }
    }

    override fun toString(): String {
        return maze.joinToString(
                separator = "\n",
                transform = { it.joinToString(separator = "") }
        )
    }

    fun show() = println(this)

    fun isOutside(point: Point) =
        (point.y !in maze.indices) || (point.x !in maze[point.y].indices)

    fun isEmptySquare(point: Point) =
        !isOutside(point) && maze[point.y][point.x] in " S"

    fun markSquare(point: Point) { maze[point.y][point.x] = 'x' }

    fun unmarkSquare(point: Point) { maze[point.y][point.x] = ' ' }
}
