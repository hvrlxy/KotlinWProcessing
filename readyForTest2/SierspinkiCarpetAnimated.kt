import processing.core.PApplet

var n = 0
var array = mutableListOf(0f, 0f, 0f, 0f)
fun main(args: Array<String>) {
     n = args[0].toInt()
     PApplet.main("Sierspinki")
}

class Sierspinki : PApplet() {
    override fun settings(){
        size(800,800)
    }

    override fun setup(){
        background(0)
        stroke(255)
        sierspinki(0f,0f,800f,n)
        frameRate(50f)
    }

    override fun draw(){
        if (array.size == 0){
            exit()
        }
        array.removeAt(0)
		array.removeAt(0)
		array.removeAt(0)
		array.removeAt(0)
		fill(dist(0F,0F,array[0],array[1])* 0.3F, dist(200F,200F, array[0], array[1])* 0.4f, dist(400F,400F,array[0], array[1])* 0.5f)
		rect(array[0], array[1], array[2],array[3])
    }

    fun sierspinki(x: Float, y: Float, size: Float, level: Int){
        if (level == 0){
            fill(random(0f,255f), random(0f, 255f), random(0f, 255f))
            stroke(0)
            val a = listOf(x + size / 3f, y + size / 3f, size / 3f, size / 3f)
            array.addAll(a)
        }
        else{
            stroke(0)
            fill(random(0f,255f), random(0f, 255f), random(0f, 255f))
            val a = listOf(x + size / 3f, y + size / 3f, size / 3f, size / 3f)
            array.addAll(a)
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

