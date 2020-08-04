import processing.core.PApplet

var n = 0F
var i = 0

fun main(args:Array<String>){
	n = args[0].toFloat()
	PApplet.main("FlowerPetals")
}

class FlowerPetals : PApplet(){
	override fun settings(){
		size(400,400)
	}

	override fun setup(){
		background(200F)
	}

	override fun draw(){
		stroke(0F)
		fill(242F,103F,119F)
		translate(200F,200F)
		val nInt = n.toInt()
		for (i in 0 until nInt){
			rotate(TWO_PI/n)
			arc(0F,-50F,20F,100F,HALF_PI,PI+HALF_PI);
  			arc(0F,-50F,20F,100F,PI+HALF_PI,TWO_PI+HALF_PI);
		}
		fill(242F,223F,7F)
		ellipse(0F,0F,20F,20F)
		noLoop()
	}
}