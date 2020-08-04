import processing.core.PApplet
var n = 0

fun main(args: Array<String>) {
    n = args[0].toInt()
    PApplet.main("Plus")
}

class Plus: PApplet(){
    override fun settings(){
        size(500, 500)
    }

    override fun setup(){
        background(0f)
        stroke(0f)
    }

    override fun draw(){
        plus(0f, 0f, 500f, n)
        noLoop()
    }

    fun plus(x: Float, y: Float, size: Float, level: Int){
        if(level == 0){
            //stop()
            fill(random(255f), random(255f), random(255f))
            rect(x + size/3f, y, size/3f, size/3f)
            fill(random(255f), random(255f), random(255f))
            rect(x + size/3f, y + size/3f, size/3f, size/3f)
            fill(random(255f), random(255f), random(255f))
            rect(x, y + size/3f, size/3f, size/3f)
            fill(random(255f), random(255f), random(255f))
            rect(x + 2*size/3f, y + size/3f, size/3f, size/3f)
            fill(random(255f), random(255f), random(255f))
            rect(x + size/3f, y + 2*size/3f, size/3f, size/3f)
        }

        else{ 
            plus(x + size/3f, y, size/3f, level - 1)
            plus(x + size/3f, y + size/3f, size/3f, level - 1)
            plus(x, y + size/3f, size/3f, level - 1)
            plus(x + 2*size/3f, y + size/3f, size/3f, level - 1)
            plus(x + size/3f, y + 2*size/3f, size/3f, level - 1)
        }
    }
}
