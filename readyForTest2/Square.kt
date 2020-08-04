import processing.core.PApplet
var n = 0

fun main(args: Array<String>) {
     n = args[0].toInt()
     PApplet.main("Square")
}

class Square: PApplet(){
    override fun settings(){
        size(500,500)
    }

    override fun setup(){
        background(255f)
        stroke(0f)
        strokeWeight(5f)
    }
    
    override fun draw(){
        square(0f, 0f, 500f, n)
        noLoop()
    }
    
    fun square(x: Float, y: Float, size: Float, level: Int){
        if (level == 0){
            line(x + size/2f, y,x + size/2f,y + size)
            line(x, y + size/2f, x + size,y + size/2f)
        }
        else{
            line(x + size/2f, y, x + size/2f, y + size)
            line(x, y + size/2f, x + size, y + size/2f)
            square(x, y + size/2f, size/2f, level - 1)
            square(x + size/2f, y + size/2f, size/2f, level - 1)
        }
    }
}
