import processing.core.PApplet

fun main(args:Array<String>){
	PApplet.main("Design3")
}

class Design3 : PApplet(){
	override fun settings(){
		size(400,400)
	}

	override fun setup(){
		background(255F)
	}

	override fun draw(){
		noStroke()
		fill(0F)
		quad(100F,0F,300F,0F,300F,400F,100F,400F)
		quad(0F,100F,400F,100F,400F,300F,0F,300F)
		fill(200F)
		quad(200F,0F,400F,200F,200F,400F,0F,200F)
		noLoop()
	}
}