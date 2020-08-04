import processing.core.PApplet

fun main(args:Array<String>){
	PApplet.main("Design4")
}

class Design4 : PApplet(){
	override fun settings(){
		size(400,400)
	}

	override fun setup(){
		background(255)
	}

	override fun draw(){
		noStroke()
		fill(0F)
		triangle(100F,0F,200F,100F,300F,0F)
		triangle(0F,100F,100F,200F,0F,300F)
		triangle(100F,400F,200F,300F,300F,400F)
		triangle(400F,100F,300F,200F,400F,300F)

		fill(200F)
		quad(200F,0F,400F,200F,200F,400F,0F,200F)

		rect(0F,0F,100F,100F)
		rect(0F,300F,100F,100F)
		rect(300F,300F,100F,100F)
		rect(300F,0F,100F,100F)

		noLoop()
	}
}