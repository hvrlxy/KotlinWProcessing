import processing.core.PApplet
import kotlin.math.*

var n = 0
var angle = 0F
var prob = 0F
var rd = 0F

fun main(args:Array<String>){
	n = args[0].toInt()
	prob = args[1].toFloat()
	PApplet.main("DreamCatcher")
}

class DreamCatcher : PApplet(){
	override fun settings(){
		size(400,400)
	}

	override fun setup(){
		background(255F)
	}

	var A1 = FloatArray(2*n+1)

	override fun draw(){
		translate(200F,200F)
		strokeWeight(5F)
		for (i in 1..n){
			point(100F*cos(angle), 100F*sin(angle))
			A1[i] = 100F * cos(angle)
			A1[n+i] = 100F * sin(angle) 
			angle = angle + TWO_PI/n
		}

		for (i in 1..n){
			for (j in (i+1)..n){
				rd = random(0F,1F)
				if (rd < prob){
					stroke(200F)
					strokeWeight(1F)
					line(A1[i],A1[i+n],A1[j],A1[j+n])
				}
			}
		}
		noLoop()
	}
}