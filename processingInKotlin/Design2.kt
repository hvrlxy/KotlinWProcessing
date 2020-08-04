import processing.core.PApplet

fun main (args: Array<String>){
	PApplet.main("Design2")
}

class Design2 : PApplet(){
	override fun settings(){
		size(400,400)
	}

	override fun setup(){
		background(0)
	}

	override fun draw(){
		noStroke()
		fill(255F)
		quad(100F,0F,400F,300F,300F,400F,0F,100F)
		quad(300F,0F,400F,100F,100F,400F,0F,300F)
		fill(200F)
		quad(200F,0F,400F,200F,200F,400F,0F,200F)
	}
}