// PRINTING BALLS - WHILE LOOP STUFF!!!!!!!!

float x = 0;

void setup(){
  size(400,400);
}

void draw(){
  background(0);
  
  x = 0;
  while (x < width){
    if (mouseX <1){
    x = x + 1;}
    else{
      x = x + mouseX;}
    fill(101);
    stroke(255);
    ellipse(x, 200, 30, 30);
  }
}
