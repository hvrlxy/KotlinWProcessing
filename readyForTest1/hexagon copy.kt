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
		background(255f,0f,0f)
	}

	override fun draw(){
		translate(120F,120F)
		val length = 100f
		fill(0f,255f,0f)
		beginShape()
		for (i in 0 until 6){
			vertex(length.toFloat() * cos(angle), length.toFloat() * sin(angle))
			angle = angle + PI/3
		}
		endShape()
		noLoop()
	}
}