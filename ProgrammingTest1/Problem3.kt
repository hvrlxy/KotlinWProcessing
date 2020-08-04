import processing.core.PApplet

const val NUM_POINTS = 50000  // number of points to plot
var n = 0
var x = 0f
var y = 0f
var angle = 0f
var r = 0f

fun main(args: Array<String>) {
    if (args.size != 1){
        println("Please provide a valid positive integer.")
        System.exit(-1)
    }

    n = args[0].toInt()
    PApplet.main("RoseSketch")
}

class RoseSketch : PApplet() {
    // The rose is 600x600, centrally placed in the drawing window.
    val SIZE = 640
    val MARGIN = 20F

    override fun settings() { size(SIZE, SIZE) }
    override fun setup() {
        background(255F)
        noLoop()
    }

    override fun draw() {
        // WRITE YOUR CODE HERE
        translate(SIZE.toFloat()/2,SIZE.toFloat()/2)
        rotate(-PI/2)
        for (i in 0 until NUM_POINTS){
            angle = angle + TWO_PI/NUM_POINTS
            r = sin(n*angle)
            x = r * sin(angle)
            y = r * cos(angle)
            point(200F*x,200F*y)
        }
    noLoop()

    }
}