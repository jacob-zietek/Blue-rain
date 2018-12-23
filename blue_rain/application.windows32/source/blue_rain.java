import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class blue_rain extends PApplet {

Rain[] rain = new Rain[5000];

public void setup(){
  
  for (int i = 0; i < rain.length; i++){
    rain[i] = new Rain();
  }
  
}

public void draw(){
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
    s = random(.5f, 1.75f); //stroke weight
    z = map(s, .5f, 1.75f, 2, 4.5f); //gravity
    a = map(s, .5f, 1.75f, 100, 255); //alpha value
  }
  
  public void update(){
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
    y = y + z*1.175f; //adds gravity
  }
  
}
  public void settings() {  fullScreen(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "blue_rain" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
