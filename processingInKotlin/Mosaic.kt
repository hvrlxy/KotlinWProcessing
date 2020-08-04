import processing.core.PApplet

var n = 0

fun main(args: Array<String>){
	n = args[0].toInt()
	PApplet.main("Mosaic")
}

class Mosaic : PApplet(){
	override fun settings(){
		size(n*100,n*100)
	}

	override fun setup(){
		background(0F)
	}

	override fun draw(){
		for (i in 0 until n){
			for (j in 0 until n){
				pinwheel(i*100F,j*100F)
			}
		}
		noLoop()
	}

	fun pinwheel(x: Float, y: Float){
		val a = 100F/3F
		val b = 200F/3F
		rect(x,y,a,b)
		rect(a+x,y,b,a)
		rect(b+x,a+y,a,b)
		rect(x,b+y,b,a)
	}
}