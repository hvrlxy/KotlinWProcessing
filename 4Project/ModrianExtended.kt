import processing.core.PApplet

var newScreen = false

fun main (args:Array<String>){
	PApplet.main("MondrianExtended")
}

class MondrianExtended : PApplet (){
	override fun settings(){
		size(840,600)
	}

	override fun setup(){
		background(255)
		stroke(0)
		mondrian(0F,0F,840F,600F)
	}

	override fun draw(){
		if (mousePressed){
			mondrian(0F,0F,840F,600F)
		}
	}

	fun mondrian(x: Float, y: Float, w: Float, h: Float){
		var random = random(0F, 1F)

		if ((w > 420F && h > 300F) || (w > 60F && h > 60F && random < 4F/9F)){
			option1(x,y,w,h)
		}

		else if((w > 420F) || (w > 60F && random < 2F/3F) ){
			option2(x,y,w,h)
		}

		else if((h > 300F) || (h > 60F&& random < 2F/3F)){
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

		fill(dist(mouseX.toFloat(),mouseY.toFloat(),x,y).toFloat()*0.3f,dist(mouseX.toFloat(),mouseY.toFloat(),width.toFloat(),height.toFloat()).toFloat()*0.3f,100f - dist(mouseX.toFloat(),mouseY.toFloat(),0f,height.toFloat()).toFloat()*0.3f)
		rect(x,y,w,h)

		mondrian(x,y,(vP - x),(hP - y))
		mondrian(vP,y,(x + w - vP),(hP - y))
		mondrian(x,hP,(vP - x),(y + h - hP))
		mondrian(vP,hP,(x + w - vP),(y + h - hP))
	}

	fun option2(x: Float, y: Float, w: Float, h: Float){
		var vP = random(x + w/3F, x + 2*w/3)

		stroke(0)

		line(vP,y,vP,(y + h))

		fill(dist(mouseX.toFloat(),mouseY.toFloat(),x,y).toFloat()*0.3f,dist(mouseX.toFloat(),mouseY.toFloat(),width.toFloat(),height.toFloat()).toFloat()*0.3f,dist(mouseX.toFloat(),mouseY.toFloat(),0f,height.toFloat()).toFloat()*0.3f)
		rect(x,y,w,h)

		mondrian(x,y,(vP - x),h)
		mondrian(vP,y,(x + w - vP),h)
	}

	fun option3 (x: Float, y: Float, w: Float, h: Float){
		var hP = random(y + h/3F, y + 2F*h/3F)

		stroke(0)
		
		line(x,hP,(x + w),hP)

		fill(dist(mouseX.toFloat(),mouseY.toFloat(),x,y).toFloat()*0.3f,dist(mouseX.toFloat(),mouseY.toFloat(),width.toFloat(),height.toFloat()).toFloat()*0.3f,dist(mouseX.toFloat(),mouseY.toFloat(),0f,height.toFloat()).toFloat()*0.3f)
		rect(x,y,w,h)

		mondrian(x,y,w,(hP - y))
		mondrian(x,hP,w,(y + h - hP))	
	}

	fun option4(x: Float, y: Float, w: Float, h: Float){
		stroke(0)

		fill(dist(mouseX.toFloat(),mouseY.toFloat(),x,y).toFloat()*0.3f,dist(mouseX.toFloat(),mouseY.toFloat(),width.toFloat(),height.toFloat()).toFloat()*0.3f,dist(mouseX.toFloat(),mouseY.toFloat(),0f,height.toFloat()).toFloat()*0.3f)
		rect(x,y,w,h)
	}
}



















