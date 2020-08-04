import processing.core.PApplet

var n = 0
fun main(args: Array<String>) {
     n = args[0].toInt()
     PApplet.main("Sierspinki")
}

class Sierspinki : PApplet() {
    override fun settings(){
        size(500,500)
    }

    override fun setup(){
        background(0)
        stroke(255)
        sierspinki(0f,0f,500f,n)
    }

    override fun draw(){
        noLoop()
    }

    fun sierspinki(x: Float, y: Float, size: Float, level: Int){
        if (level == 0){
            fill(random(0f,255f), random(0f, 255f), random(0f, 255f))
            stroke(0)
            rect(x + size / 3f, y + size / 3f, size / 3f, size / 3f)
        }
        else{
            stroke(0)
            fill(random(0f,255f), random(0f, 255f), random(0f, 255f))
            rect(x + size / 3f, y + size / 3f, size / 3f, size / 3f)
            sierspinki(x, y, size/3f, level - 1)
            sierspinki(x, y + size/3f, size/3f, level - 1)
            sierspinki(x, y + size * 2/3f, size/3f, level - 1)
            sierspinki(x + size/3f, y, size/3, level - 1)
            sierspinki(x + size/3f, y + 2 * size/3, size / 3, level - 1)
            sierspinki(x + 2 * size/3f, y, size/3f, level - 1)
            sierspinki(x + 2 * size/3f, y + size/3f, size/3f, level - 1)
            sierspinki(x + 2 * size/3f, y + size * 2/3f, size/3f, level - 1)
        }
    }
}

