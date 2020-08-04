import processing.core.*
import kotlin.math.abs
var level = 0


fun main (args:Array<String>){
	level = args[0].toInt()
	PApplet.main("Sierpinski")
}

class Sierpinski: PApplet(){
	override fun settings(){
		size(600,400)
	}

	override fun setup() {
		background(255)
		stroke(0)
	}

	override fun draw() {
		Sierpinski(300f,50f,100f,300f,500f,300f,level)
		noLoop()
	}




	fun Sierpinski (x1: Float, y1: Float, x2: Float, y2: Float, x3: Float, y3: Float, n: Int){
		if (n == 1){
			triangle(x1,y1,x2,y2,x3,y3)
		}




	fun triangle1 (x1: Float, y1: Float, x2: Float, y2: Float, x3: Float, y3: Float){
			triangle(x1,y1,x2,y2,x3,y3)

			var newX1 = (x1 + x2)/2f
			var newX2 = (x2 + x3)/2f
			var newX3 = (x3 + x1)/2f

			var newY1 = (y1 + y2)/2f
			var newY2 = (y2 + y3)/2f
			var newY3 = (y1 + y3)/2f

			Sierpinski(newX1, newY1, newX2, newY2, newX3, newY3, n-1)
		}

	}

}
