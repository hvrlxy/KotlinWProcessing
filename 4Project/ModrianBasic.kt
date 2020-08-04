import processing.core.PApplet

var newScreen = false

fun main (args:Array<String>){
	PApplet.main("MondrianBasic")
}

class MondrianBasic : PApplet (){
	override fun settings(){
		size(840,600)
	}

	override fun setup(){
		background(255)
		stroke(0)
	}

	override fun draw(){
		mondrian(0F,0F,840f,600f)
		noLoop()
	}

	fun mondrian(x: Float, y: Float, w: Float, h: Float){
		val random = random(0f .. 1f)

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

		stroke(0)

		line(vP,y,vP,(y + h))
		line(x,hP,(x + w),hP)

		mondrian(x,y,(vP - x),(hP - y))
		mondrian(vP,y,(x + w - vP),(hP - y))
		mondrian(x,hP,(vP - x),(y + h - hP))
		mondrian(vP,hP,(x + w - vP),(y + h - hP))
	}

	fun option2(x: Float, y: Float, w: Float, h: Float){
		var vP = random(x + w/3F, x + 2*w/3)

		stroke(0)

		line(vP,y,vP,(y + h))

		mondrian(x,y,(vP - x),h)
		mondrian(vP,y,(x + w - vP),h)
	}

	fun option3 (x: Float, y: Float, w: Float, h: Float){
		var hP = random(y + h/3F, y + 2F*h/3F)

		stroke(0)
		
		line(x,hP,(x + w),hP)

		mondrian(x,y,w,(hP - y))
		mondrian(x,hP,w,(y + h - hP))	
	}

	fun option4(x: Float, y: Float, w: Float, h: Float){
		var rd = random(0F,1F)

		stroke(0)

		if (rd < 0.25F){
			val rd1 = random(0F,1F)
			if (rd1 <= 1/3F){
				fill(89f, 227f, 235f)
			}
			else if ((rd1 > 1/3F) && (rd1 < 2/3F)){
				fill(247f, 233f, 69f)
			}
			else{
				fill(237f, 9f, 47f)
			}
		}

		else{
			fill(255f)
		}
		rect(x,y,w,h)
	}
}



















