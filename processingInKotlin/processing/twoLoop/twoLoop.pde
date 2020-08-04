//GRID PROBLEMS - TWO LOOPS
float x = 0;
float y = 0;
float spacing = 20;

void setup(){
  size (400,400);
}

void draw(){
  
  background(255);
  stroke(0);
  
  spacing = spacing + random(-2,2);
  
  x = 0;
  y = 0;
  while (x < width){
    line(x,0,x,400);
    x = x + spacing;
  }
  while (y < height){
    line (0,y,400,y);
    y = y + spacing;
  }
}
