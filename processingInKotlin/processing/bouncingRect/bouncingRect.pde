// FLOATING BOUNCING RECTANGLE
float x = 20;
float y = 200;
float xSpeed = 5;

void setup() {
  size(400,400);
}

void draw(){
  stroke(255);
  strokeWeight(10);
  fill(255);
  point(x,y);
    
    x = x + xSpeed;
   if ((x >200) || (x<20)){
     xSpeed = -xSpeed;
   }
}
