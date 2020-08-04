float angleChange = TWO_PI / 50;
float angle = 0.0;

void settings(){
  size(400,400);
}

void setup(){
  background(200);
}

void draw(){
  stroke(0);
  strokeWeight(1);
  fill(255);
  
  for (int i = 0; i <400; i = i+2){
      angle = angle + angleChange;
      ellipse(i, 200 + 50*sin(angle),5,5);
  }
  noLoop();
}
