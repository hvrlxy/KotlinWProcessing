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
		bear2(60F,  80F, 200F, 200F)  
    	bear2(260F, 20F, 200F, 150F)  
    	bear2(280F, 180F, 150F, 200F)  
    	bear2(450F,  40F, 300F, 300F)     
	}

	fun bear2(x: Float, y:Float, w:Float, h: Float){
		translate(x,y);
		scale(w/400F,h/400F);

		fill(198F,117F,10F);
		strokeWeight(4F);

		ellipse(300F,105F,120F,120F); //draw the outer right ear of the bear
		fill(0F);
		ellipse(300F,105F,80F,80F); //draw the inner right ear of the bear

		fill(198F,117F,10F);
		ellipse(100F,105F,120F,120F); //draw the outer left ear of the bear
		fill(0F);
		ellipse(100F,105F,80F,80F); //draw the inner left ear of the bear

		fill(198F,117F,10F);
		ellipse(200F,225F,250F,250F); //draw the face of the bear

		fill(0F);
		ellipse(165F,195F,40F,60F); //draw the left eye
		ellipse(235F,195F,40F,60F); //draw the right eye

		fill(255F);
		ellipse(165F,185F,20F,20F); //draw the left pupil
		ellipse(235F,185F,20F,20F); //draw the right pupil

		fill(252F,189F,125F);
		ellipse(200F,290F,115F,85F); //draw the mouth

		fill(0F);
		ellipse(200F,280F,65F,42F); //draw the nose
		line(200F,280F,200F,320F);
		noFill();
		stroke(0F);
		arc(200F,300F,65F,42F,0F, PI); //draw the smile

		noLoop()

		scale(400F/w,400F/h)
		translate(-x,-y)
	}
}
