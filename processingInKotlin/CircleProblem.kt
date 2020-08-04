import processing.core.PApplet
import kotlin.random.*

var n = 0
var p: Float = 0f

fun main(args: Array<String>) {
	n = args[0].toInt()
	p = args[1].toFloat()
	PApplet.main("Circle")
}

class Circle : PApplet() {
	val win_size = 400
	val origin = ((win_size-1)/2).toInt()
	val points = Array(n + 1) {i -> FloatArray(2) {j -> 0f}}
	var pointer = 0
	
	override fun settings(){
		size(win_size, win_size)
	}
	
	override fun setup() {
		strokeWeight(3f)
		var angle: Float = 0f
		for (i in n downTo 1) {
			angle = i*((2f*PI)/n)
			val x = (100*cos(angle)+origin).toFloat()
			val y = (100*sin(angle)+origin).toFloat()
			point(x, y)
			points[i-1] = floatArrayOf(x, y)
			println("${points[i][0]}")	
		}
	}
	
	override fun draw() {
		if (pointer < n){
			for (i in 0..n-1) {
				val r = Random.nextFloat()
				if (r < p) {
					line(points[pointer][0], points[pointer][1], points[i][0], points[i][1])
				}
			pointer++
			}
		}
		else stop()
	}
}