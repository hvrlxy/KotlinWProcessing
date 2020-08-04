

//// MY PROGRAM:
//void setup() {
//     size(400,400);
//     stroke(0);
//     background(192,64,0);
//}
//    void draw(){
//      fill(255,255,255);
//      circle(mouseX, mouseY, 55);
//    }

//void setup() {
//       size(400, 400);
//       stroke(255);
//     }
      
//     void draw() {
//       line(150, 25, mouseX, mouseY);
//     }
     
//     void mousePressed() {
//       background(192, 64, 0);
//     }
    
     
//// ALIENS EXERCISE
     //size(400,400);
     
     //rectMode(CENTER);
     //rect(200,200,40,200);
     //ellipseMode(CENTER);
     //ellipse(200,100,100,100);
     
     //ellipse(170,100,30,50); 
     //ellipse(230,100,30,50);
     
     //line(180,300,160,320);
     //line(220,300,240,320);
     
//color c = color(0);
//float x = 0;
//float y = 100;
//float speed = 1;

//void setup() {
//  size(200,200);
//}

//void draw() {
//  background(255);
//  move();
//  display();
//}

//void move() {
//  x = x + speed;
//  if (x > width) {
//    x = 0;
//  }
//}

//void display() {
//  fill(c);
//  rect(x,y,30,10);
//}
     
////MOVING CIRCLE:

//color c = color(255,0,0,100);
//float x = 50;
//float y = 200;

//void setup() {
//  size(400,400);
//}

//void draw() {
//  background (255);
//  move();
//  display();
//}

//void move() {
//  x = x + 1;
//  if (x > 400){
//    x =0;
//  }
//  //y = y + 1;
//  //if (y > 400){
//  //  y = 0;
//  //}
//}
//void display(){
//  fill(c);
//  ellipse(x,y,50,50);
//}

//// FLOATING BOUNCING RECTANGLE
//float x = 0;
//float y = 200;
//float xSpeed = 5;

//boolean going = false;

//void setup() {
//  size(400,400);
//}

//void draw(){
//  background(192,64,0);
//  stroke(255);
//  fill(255);
//  rect(x,y,50,100);
  
//  if (going){
//    x = x + xSpeed;
//  }
//   //else {
//   //  x = 0;}
   
//   if ((x > 350)||(x < 0)){
//     xSpeed = -(xSpeed)* 1.1 ;}
//}

//void mousePressed(){
//  going = !going;
//}

//// PRINTING BALLS - WHILE LOOP STUFF!!!!!!!!
//float x = 0;

//void setup(){
//  size(400,400);
//}

//void draw(){
//  background(0);
  
//  x = 0;
//  while (x < width){
//    if (mouseX <1){
//    x = x + 1;}
//    else{
//      x = x + mouseX;}
//    fill(101);
//    stroke(255);
//    ellipse(x, 200, 30, 30);
//  }
//}

//// MY WHILE LOOP VERSION
//float x = 0;
//float y = 0;

//void setup(){
//  size(400,400);
//}

//void draw(){
//  background(0);
  
//  x = 0;
//  y = 0;
//  while ((x < width)||(y < height)){
//    if ((mouseX == 0)||(mouseY == 0)){
//    x = x + 1;
//    y = y + 1;}
//    else{
//      x = x + mouseX;
//      y = y + mouseY;}
//    fill(101);
//    stroke(255);
//    ellipse(x, y, 30, 30);
//  }
//}

////GRID PROBLEMS - TWO LOOPS
//float x = 0;
//float y = 0;
//float spacing = 20;

//void setup(){
//  size (400,400);
//}

//void draw(){
  
//  background(255);
//  stroke(0);
  
//  spacing = spacing + random(-2,2);
  
//  x = 0;
//  y = 0;
//  while (x < width){
//    line(x,0,x,400);
//    x = x + spacing;
//  }
//  while (y < height){
//    line (0,y,400,y);
//    y = y + spacing;
//  }
//}

////FOR LOOPS
//int x = 0;
//while (x < 11){
//  print(x);
//  x = x + 1;
//}

//for (int x = 0; x <11; x = x + 1){
//  print (x);}

//// VARIABLE SCOPE


  


 

    
