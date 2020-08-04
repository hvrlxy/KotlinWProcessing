import processing.core.PApplet

var level = 0

fun main(args: Array<String>) {
    level = args[0].toInt()
    PApplet.main("Fractal")
}

class Fractal : PApplet() {
    val SIZE = 640
    override fun settings() { size(SIZE, SIZE) }
    override fun setup() { noLoop() }
    override fun draw() {
        fractal(0F, 0F, SIZE.toFloat(), level)
    }

    fun fractal(x: Float, y: Float, side: Float, level: Int) {
        if (level == 0) {
            fill(0)
            rect(x, y, side, side)
        } else {
            // WRITE YOUR CODE HERE
            fractal(x, y, side/4f, level - 1)
            fractal(x + side * 3f/4f, y, side/4f, level - 1)
            fractal(x + side/4f, y + side/4f, side/2f, level - 1)
            fractal(x, y + side * 3f/4f, side/4f, level - 1)
            fractal(x + 3f * side/4f, y + side * 3f/4f, side/4f, level - 1)
        }
    }
}
