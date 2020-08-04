import processing.core.PApplet

fun main (args:Array<String>){
	PApplet.main("Bears")
}

class Bears : PApplet(){
	override fun settings(){
		size(800,400)
	}

	override fun setup(){
		background(200)
	}

	override fun draw(){
		bear1(60F,  80F, 200F, 200F)  
    	bear1(260F, 20F, 200F, 150F)  
    	bear1(280F, 180F, 150F, 200F)  
    	bear1(450F,  40F, 300F, 300F)
    	noLoop()  
	}

	fun bear1(x: Float, y:Float, w:Float, h: Float){

		fill(198F,117F,10F)
		strokeWeight(4F*(w/400F))

		ellipse(x+0.75F*w,0.25F*h+y,0.3F*w,0.3F*h)
		fill(0F)
		ellipse(0.75F*w+x,0.25F*h+y,0.2F*w,0.2F*h)

		fill(198F,117F,10F)
		ellipse(0.25F*w+x,y+0.25F*h,0.3F*w,0.3F*h)
		fill(0F)
		ellipse(0.25F*w+x,y+0.25F*h,0.2F*w,0.2F*h)

		fill(198F,117F,10F)
		ellipse(0.5F*w+x,y+0.5625F*h,0.625F*w,0.625F*h)

		fill(0F)
		ellipse(0.4125F*w+x,y+0.4875F*h,0.1F*w,0.15F*h) //left eye
		ellipse(0.5875F*w+x,y+0.4875F*h,0.1F*w,0.15F*h)

		fill(255F)
		ellipse(0.4125F*w+x,y+0.4625F*h,0.05F*w,0.05F*h) //right eye
		ellipse(0.5875F*w+x,y+0.4625F*h,0.05F*w,0.05F*h)

		fill(252F,189F,125F)
		ellipse(0.5F*w+x,y+0.725F*h,0.2875F*w,0.2125F*h)

		fill(0F)
		ellipse(0.5F*w+x,y+0.7F*h,0.1625F*w,0.105F*h)
		line(0.5F*w+x,y+0.7F*h,0.5F*w+x,y+0.8F*h)
		noFill()
		stroke(0F)
		arc(0.5F*w+x,y+0.75F*h,0.1625F*w,0.105F*h,0F, PI)

		noLoop() 
	}
}