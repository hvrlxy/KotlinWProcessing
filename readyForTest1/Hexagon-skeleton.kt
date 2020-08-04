import processing.core.PApplet
var angle = 0F

fun main(args: Array<String>) { PApplet.main("Hexagon") }

class Hexagon : PApplet() {
    val MARGIN = 20
    val MARGIN_F = MARGIN + 0F  // MARGIN as a float
    val HEXWIDTH = 200

    override fun settings() {
        size(HEXWIDTH + 2*MARGIN, HEXWIDTH + 2*MARGIN)
    }

    override fun setup() {
        noLoop()
    }

    override fun draw() {
        // YOUR CODE GOES HERE
        translate(120F,120F)
        val length = 100
        for (i in 0 until 6){
            line(length.toFloat() * cos(angle),length.toFloat() * sin(angle), length.toFloat()* cos(angle + PI/3), length.toFloat() * sin(angle + PI/3))
            angle = angle + PI/3
        }
        noLoop()
    }
}
