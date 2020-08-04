import processing.core.PApplet

fun main(args:Array<String>){
  PApplet.main("DigitalClock")
}

class DigitalClock : PApplet(){
  override fun settings(){
    size(400,400);
  }

  override fun setup(){
    fill(255F);
    frameRate(60F);
  }

  override fun draw(){
  background(200F);
  
  //draw the clock
  stroke(1F);
  rectMode(CENTER);
  fill(255F);
  rect(200F,200F,350F,250F);
  
  //set the hour, minute and second
  var h = hour();
  var m = minute();
  var s = second();
  
  textSize(64F);
  fill(0F);
  if (s<10){
    text(h.toInt() + ":" + m.toInt() + ":" + "0" + s.toInt(), 60, 220);
    }
  else {
    text(h.toInt() + ":" + m.toInt() + ":" + s.toInt(), 60, 220);
    }
  }
}