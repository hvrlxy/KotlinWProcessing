import processing.core.*
var level0 = 0

fun main(args:Array<String>){
	level0 = args[0].toInt()
	PApplet.main("Htree")
}

class Htree : PApplet (){
	override fun settings(){
		size(800,400)
	}
	override fun setup(){
		background(255)
		stroke(0)
	}

	override fun draw(){
		Htree(width/2F, height/2F, 200F, level0)
		noLoop()
	}

	fun Htree(x: Float, y: Float, length: Float, level: Int){
		if ((level % 2 == 1) && (level != 0)){
			oddLevel(x,y,length, level)
		}
		else if ((level % 2 == 0) && (level != 0)){
			evenLevel(x,y,length, level)
		}
		else{
			stop()
		}
	}

	fun oddLevel(x: Float, y: Float, length: Float, level: Int){
		line(x - length, y, x + length, y)
		var newlv = level - 1
		Htree(x - length, y, length, newlv)
		Htree(x + length, y, length, newlv)
	}

	fun evenLevel(x: Float, y: Float, length: Float, level: Int){
		line(x, y - length/2F, x , y + length/2F)
		var newLength = length/2F
		var newlv = level - 1
		Htree(x, y - newLength, newLength, newlv)
		Htree(x, y + newLength, newLength, newlv)
	}
}