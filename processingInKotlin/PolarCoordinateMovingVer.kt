import processing.core.PApplet

var angle = 0F
var r = 0F
var x = 0F
var y = 0F

fun main(args:Array<String>){
	PApplet.main("PolarCoordinateMovingVer")
}

class PolarCoordinateMovingVer : PApplet(){
	override fun settings(){
		size(400,400)
	}

	override fun setup(){
		background(255F)
	}

	override fun draw(){
		stroke(192f,64f,10f)
		translate(200F,200F)
		for (i in 0 until 50000){
			angle = angle + TWO_PI/50000F
			r = sin(mouseX*angle) + cos(mouseY*angle)
			x = r * sin(angle)
			y = r * cos(angle)
			point(100F*x,100F*y)
		}
	}
}