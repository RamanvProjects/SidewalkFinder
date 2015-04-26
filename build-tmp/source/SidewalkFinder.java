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

public class SidewalkFinder extends PApplet {

//First experimentation with using processing as a visualization system

public void setup() {	
	size(800, 400, "processing.core.PGraphicsRetina2D");
}

public void draw() {
	Agent age = new Agent(200, 300);

	ellipse(age.getX(), age.getY(), 20, 20);
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SidewalkFinder" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
