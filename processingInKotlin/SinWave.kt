import processing.core.PApplet

var i = 0
var angle = 0F

fun main(args:Array<String>){
  PApplet.main("SinWave")
}

class SinWave : PApplet(){
  override fun settings(){
    size(400,400);
  }

  override fun setup(){
    stroke(0F);
    strokeWeight(1F);
    fill(255);

    var angleChange = TWO_PI /50F
  
    for (i in 0 until 400){
      angle = angle + angleChange;
      ellipse(i.toFloat(), 200F + 50F*sin(angle),5F,5F);
  }
  noLoop()
  }
}
