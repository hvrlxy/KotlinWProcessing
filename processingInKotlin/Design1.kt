import processing.core.PApplet

fun main (args:Array<String>){
	PApplet.main("Design1")
}

class Design1 : PApplet(){
	override fun settings(){
		size(400,400)
	}

	override fun setup(){
		background(0F)
	}

	override fun draw(){
		fill(200F)
		quad(200F,0F,400F,200F,200F,400F,0F,200F)
		fill(255F)
		triangle(100F,0F,0F,100F,100F,100F)
		triangle(300F,0F,400F,100F,300F,100F)
		triangle(0F,300F,100F,300F,100F,400F)
		triangle(300F,300F,400F,300F,300F,400F)
		noLoop()
	}
}