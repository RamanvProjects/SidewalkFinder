import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.Random; 
import java.util.ArrayList; 

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




int width = 800;
int height = 400;
int col = color(66, 168, 237, 200);
ArrayList<Agent> agents = new ArrayList<Agent>();
boolean drawPaths = false;
//try making gravity sim
//as an example


public void setup() {	
	size(width, height, "processing.core.PGraphicsRetina2D");
	drawPaths = false;
	//Initializing agents
	Random r = new Random();
	smooth();
	strokeWeight(0.3f);
	stroke(col);
	for (int i = 0; i < width/40; i++) {
		Agent a = new Agent(width/40*i, (int) (40*Math.sin(i) + height/2), width, r.nextInt(height));
		a.changeX((a.getDest()[0] - a.getX())/90);
		a.changeY((a.getDest()[1] - a.getY())/90);
		agents.add(a);
	}
}

public void draw() {
	background(22);
	for (int i = 0; i < agents.size(); i ++) {
		Agent a = agents.get(i);
		update(a);
		if (isOutOfBounds(a, width, height)) {
			agents.remove(i);
		} else { 
			ellipse(a.getX(), a.getY(), 20, 20);
			if (drawPaths) {
				for (int j = 0; j < a.path.size() - 1; j ++) {
					PVector p = a.path.get(j);
					PVector p1 = a.path.get(j + 1);
					line(p.x, p.y, p1.x, p1.y);
				}
			}
		}
	}
}

public boolean isOutOfBounds(Agent a, int width, int height) {
	return (a.getX() < 0 || a.getX() > width || a.getY() > height || a.getY() < 0); 
}

public void update(Agent a) {
	a.move();
}

class Agent {
	private int x;
	private int y;
	private int momentumX;
	private int momentumY;
	private int destX;
	private int destY;
	ArrayList<PVector> path = new ArrayList<PVector>();

	public Agent(int x, int y, int destX, int destY) {
		this.x = x;
		this.y = y;
		this.destX = destX;
		this.destY = destY;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public int[] getDest() {
		return new int[]{destX, destY};
	}

	public int momentX() {
		return momentumX;
	}

	public int momentY() {
		return momentumY;
	}

	public void changeX(int dx) {
		momentumX += dx;
	}

	public void changeY(int dy) {
		momentumY += dy;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void move() {
		x += momentumX;
		y += momentumY;
		path.add(new PVector(x, y));
	}
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
