Rain[] rain = new Rain[5000];

void setup(){
  fullScreen();
  for (int i = 0; i < rain.length; i++){
    rain[i] = new Rain();
  }
  
}

void draw(){
  background(153, 204, 255);
  strokeWeight(3);
  stroke(0);
  //line(0, width, width, width);
  for(int i = 0; i < rain.length; i++){
    rain[i].update();
  }
}

class Rain {
  float x;
  float y;
  float l;
  float s;
  float z;
  float a;
  //float ang;
  
  Rain(){
    x = random(0, width);
    y = random(-height, height);
    l = random(2, 5); //length
    s = random(.5, 1.75); //stroke weight
    z = map(s, .5, 1.75, 2, 4.5); //gravity
    a = map(s, .5, 1.75, 100, 255); //alpha value
  }
  
  void update(){
    stroke(0, 102, 204, a);
    strokeWeight(s);
    line(x, y, x, y-l);
    if(y > height){
      //for(int i = 0; i < 10; i++){ //responsible for the splash effect
      //  ang = random(0.1, PI - .1);
      // line(x, y-3, x + cos(ang)* (l * 2.5), y - sin(ang)*(l * 2.5));
      //}
      y = random(-height, 0); //resets the rain drop to the top
      x = random(0, width);
    }
    y = y + z*1.175; //adds gravity
  }
  
}
