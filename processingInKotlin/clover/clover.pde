void setup(){
translate(200,-346);
rotate(PI/3);


size(400,400);
smooth();
strokeWeight(3);
fill(46,188,40);
beginShape();
vertex(200, 60); 
bezierVertex(200, -20, 360, 20, 200, 160); 
vertex(200, 60); 
bezierVertex(200, -20, 40, 20, 200, 160); 
endShape();

translate(360,-40);
rotate(radians(90));

smooth();
beginShape();
vertex(200, 60); 
bezierVertex(200, -20, 360, 20, 200, 160); 
vertex(200, 60); 
bezierVertex(200, -20, 40, 20, 200, 160); 
endShape();

rotate(radians(90));
translate(-40,-360);

beginShape();
vertex(200, 60); 
bezierVertex(200, -20, 360, 20, 200, 160); 
vertex(200, 60); 
bezierVertex(200, -20, 40, 20, 200, 160); 
endShape();

rotate(radians(90));
translate(-40,-360);

beginShape();
vertex(200, 60); 
bezierVertex(200, -20, 360, 20, 200, 160); 
vertex(200, 60); 
bezierVertex(200, -20, 40, 20, 200, 160); 
endShape();
}
//void settings(){
//  size(400,400);}
  
void draw(){
  strokeWeight(4);
  stroke(0);
  noFill();
  beginShape();
  vertex(212,154);
  bezierVertex(170,319,174,321,258,373);
  endShape();
  if (mousePressed){
  print(mouseX);
  print(mouseY);
  }
}
