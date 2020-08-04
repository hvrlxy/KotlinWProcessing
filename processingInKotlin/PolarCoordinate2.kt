import processing.core.PApplet

var angle = 0F
var r = 0F
var x = 0F
var y = 0F
var n = 0

fun main(args:Array<String>){
	n = args[0].toInt()
	PApplet.main("PolarCoordinate2")
}

class PolarCoordinate2 : PApplet(){
	override fun settings(){
		size(400,400)
	}

	override fun setup(){
		background(255F)
	}

	override fun draw(){
		translate(200F,200F)
		for (i in 0 until 50000){
			angle = angle + TWO_PI/50000F
			r = cos(n*angle)
			x = r * sin(angle)
			y = r * cos(angle)
			point(100F*x,100F*y)
		}
		noLoop()
	}
}