import processing.core.PApplet

var x = 0 
var s = 50

fun main (args: Array<String>){
	if (args.size != 1){
		/* check if there is an argument */
		println("Please provide a valid argument")
		System.exit(-1)
	}

	x = args[0].toInt()

	if (x < 1){
		/* check if the input argument is a positive integer */
		println("Please provide a positive integer")
		System.exit(-1)
	}

	PApplet.main("CheckerBoard")
}

class CheckerBoard : PApplet(){
	override fun settings(){
		size (x*s,x*s) //calculate the size of the canvas
	}

	override fun setup(){
		background(255) //set the background color
	}

	override fun draw(){
		for(i in 0 until x){
			for(j in 0 until x){
					/* set the color of the rectangle */
				if ((i+1+x-j)%2 == 0){
					fill(0)
				}
				else{
					fill(255)
				}
				val sizeFloat = s.toFloat()
				noStroke()
					/* draw the rectangle */
				rect(i*sizeFloat,j*sizeFloat,sizeFloat,sizeFloat)
			}
		}
		noLoop()
	}
}