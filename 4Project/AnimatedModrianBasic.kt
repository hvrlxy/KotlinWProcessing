import processing.core.PApplet
import kotlin.random.*

var lineList = mutableListOf(0F,0F,0F,0F)
var rectList = mutableListOf(0F,0F,0F,0F)
var x = 0F
var y = 0F
var speed = 2

fun main (args:Array<String>){
	PApplet.main("AnimatedMondrianBasic")
}

class AnimatedMondrianBasic : PApplet (){
	override fun settings(){
		size(840,600)
	}

	override fun setup(){
		background(255)
		stroke(0)
		strokeWeight(5f)
		frameRate(1F)
		mondrian(0F,0F,840F,600F)
		frameRate(200F)
	}

	override fun draw(){
		if (rectList.size == 4){
			stop()
		}

		if (lineList.size == 4){
			frameRate(5F)

			fill(random(0f,255f), random(0f,255f), random(0f,255f))
			rect(rectList[0], rectList[1], rectList[2], rectList[3])

			rectList.removeAt(0)
			rectList.removeAt(0)
			rectList.removeAt(0)
			rectList.removeAt(0)
		}

		else {
			if ((x >= lineList[2]) && (y >= lineList[3])){
				lineList.removeAt(0)
				lineList.removeAt(0)
				lineList.removeAt(0)
				lineList.removeAt(0)
				x = lineList[0]
				y = lineList[1]
			}
			point(x,y)
			if (x < lineList[2]){
				x += 3
			}
			if (y < lineList[3]){	
				y += 3
			}
		}
	}

	fun mondrian(x: Float, y: Float, w: Float, h: Float){
		var random = random(0F,1F)

		if ((w > 420F && h > 300F) || (w > 100F && h > 100F && random < 4F/9F)){
			option1(x,y,w,h)
		}

		else if((w > 420F) || (w > 100F && random < 2F/3F) ){
			option2(x,y,w,h)
		}

		else if((h > 300F) || (h > 100F && random < 2F/3F)){
			option3(x,y,w,h)
		}
		else{
			option4(x,y,w,h)
		}
	}

	fun option1(x: Float, y: Float, w: Float, h: Float){
		var vP = random(x + w/3F, x + 2*w/3)
		var hP = random(y + h/3, y + 2*h/3)

		mondrian(x,y,(vP - x),(hP - y))
		mondrian(vP,y,(x + w - vP),(hP - y))
		mondrian(x,hP,(vP - x),(y + h - hP))
		mondrian(vP,hP,(x + w - vP),(y + h - hP))
	}

	fun option2(x: Float, y: Float, w: Float, h: Float){
		var vP = random(x + w/3F, x + 2*w/3)

		mondrian(x,y,(vP - x),h)
		mondrian(vP,y,(x + w - vP),h)
	}

	fun option3 (x: Float, y: Float, w: Float, h: Float){
		var hP = random(y + h/3F, y + 2F*h/3F)

		mondrian(x,y,w,(hP - y))
        mondrian(x,hP,w,(y + h - hP))	
	}

	fun option4(x: Float, y: Float, w: Float, h: Float){
		val list2 = listOf(x,y,(x+w),y)
		val list3 = listOf(x,y,x,(y+h))
		val list4 = listOf((x+w),y,(x+w),(y+h))
		val list5 = listOf(x,(y+h),(x+w),(y+h))	
		lineList.addAll(list2)
		lineList.addAll(list3)
		lineList.addAll(list4)
		lineList.addAll(list5)

		val listRect = listOf(x,y,w,h)
		rectList.addAll(listRect)
	}
}



















