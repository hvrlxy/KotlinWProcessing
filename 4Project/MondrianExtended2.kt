import processing.core.PApplet
import kotlin.random.*

//var lineList = mutableListOf(0F,0F,0F,0F)
var rectList = mutableListOf(0F,0F,0F,0F)

fun main (args:Array<String>){
	PApplet.main("MondrianExtended2")
}

class MondrianExtended2 : PApplet (){
	override fun settings(){
		size(840,600)
	}

	override fun setup(){
		background(255)
		stroke(0)
		frameRate(1F)
		mondrian(0F,0F,840F,600F)
		frameRate(5F)
	}

	override fun draw(){ 
		rectList.removeAt(0)
		rectList.removeAt(0)
		rectList.removeAt(0)
		rectList.removeAt(0)
		if (rectList.size == 0){
            exit()
        }
		fill(dist(0F,0F,rectList[0],rectList[1])* 0.3F, dist(200F,200F, rectList[0], rectList[1])* 0.4f, dist(400F,400F,rectList[0], rectList[1])* 0.5f)
		rect(rectList[0],rectList[1], rectList[2],rectList[3])
	}

	fun mondrian(x: Float, y: Float, w: Float, h: Float){
		var random = random(0F,1F)

		if ((w > 420F && h > 300F) || (w > 60F && h > 60F && random < 4F/9F)){
			option1(x,y,w,h)
		}

		else if((w > 420F) || (w > 60F && random < 2F/3F) ){
			option2(x,y,w,h)
		}

		else if((h > 300F) || (h > 60F && random < 2F/3F)){
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
		val list1 = listOf(x,y,w,h)
		rectList.addAll(list1)
	}
}



















