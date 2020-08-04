import processing.core.PApplet
var n = 0

fun main(args: Array<String>) {
     n = args[0].toInt()
     PApplet.main("Escher")
}

class Escher: PApplet(){
    override fun setup(){
        size(500,500)
        background(0)
        stroke(0)
    )

    override fun setup(){
        escher(0f, 0f, 500, n)
    }

    override fun draw(){
        noLoop()
    }

    fun escher(x: Float, y: Float, size: Float, level: Int){
        if (level == 0){
            fill(255f)
            rect(x, y, size, size)
        }
        else if (level % 2 == 0){
            rotate(PI/4)
            fill(255f)
            rect(x, y, size, size)
            newSize = kotlin.math.sqrt((size/2f) * (size/2f))
            escher(x + size/2f, y + size/2f, newSize, level - 1)
        }
        else{
            rotate(PI/4)
            fill(0f)
            rect(x, y , size, size)
            newSide = kotlin.math.sqrt((size/2f)*(size/2f))
            escher(x + size/2f, y + size/2f, newSize, level - 1)
        }
    }
}
