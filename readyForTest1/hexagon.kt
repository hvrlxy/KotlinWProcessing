import processing.core.PApplet
var angle = 0F

fun main (args:Array<String>){
	PApplet.main("hexagon")
}

class hexagon : PApplet(){
	override fun settings(){
		size(240,240)
	}

	override fun setup(){
		background(200)
	}

	override fun draw(){
		translate(120F,120F)
		val length = kotlin.math.sqrt(7500F)
		for (i in 0 until 6){
			line(length.toFloat().toFloat() * cos(angle),length.toFloat() * sin(angle), length.toFloat()* cos(angle + PI/3), length.toFloat() * sin(angle + PI/3))
			angle = angle + PI/3
		}
		noLoop()
	}
}