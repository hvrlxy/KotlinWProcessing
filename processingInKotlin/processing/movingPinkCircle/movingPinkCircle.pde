//MOVING CIRCLE:

color c = color(255,0,0,100);
float x = 50;
float y = 200;

void setup() {
  size(400,400);
}

void draw() {
  background (255);
  move();
  display();
}

void move() {
  x = x + 1;
  if (x > 400){
    x =0;
  }
  //y = y + 1;
  //if (y > 400){
  //  y = 0;
  //}
}
void display(){
  fill(c);
  ellipse(x,y,50,50);
}
