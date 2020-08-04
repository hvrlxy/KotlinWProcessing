import processing.core.PApplet
import kotlin.math.*

var n = 0F
var x = 250F
var y = 250F
var i = 0F

fun main (args: Array<String>){
  if (args.size != 1){
    println("Please provide a valid argument")
    System.exit(-1)
  }

  n = args[0].toFloat()
  PApplet.main("RandomWalker")
}

class RandomWalker : PApplet(){
  override fun settings(){
    size(500,500)
  }

  override fun setup(){
    background(200)
  }

  override fun draw(){
    noFill()
    beginShape()
    for (step in 0 until n.toInt()){
        i = random(0F,1F)
        if (i < 0.25F){
            vertex(x,y)
            x = x
            y = y - 1
        }
        else if (0.25F <= i && i < 0.5F){
            vertex(x,y)
            x = x
            y = y + 1
        }
        else if (0.5F <= i && i < 0.75F){
          vertex(x,y)
            x = x + 1
            y = y
        }
        else{
            vertex(x,y)
            x = x - 1
            y = y
        }
      }
      endShape()
      noLoop()
      var distance = (dist(x,y,250F,250F)).pow(2F)
      println("squared distance = $distance")
      noLoop()
  }
}