//First experimentation with using processing as a visualization system

import java.util.Random;
import java.util.ArrayList;

int width = 800;
int height = 400;
color col = color(66, 168, 237, 200);
ArrayList<Agent> agents = new ArrayList<Agent>();
boolean drawPaths = true;
//try making gravity sim
//as an example


void setup() {	
	size(width, height, "processing.core.PGraphicsRetina2D");
	drawPaths = false;
	//Initializing agents
	Random r = new Random();
	smooth();
	strokeWeight(0.3);
	stroke(col);
	for (int i = 0; i < width/40; i++) {
		Agent a = new Agent(width/40*i, (int) (40*Math.sin(i) + height/2), width, r.nextInt(height));
		a.changeX((a.getDest()[0] - a.getX())/90);
		a.changeY((a.getDest()[1] - a.getY())/90);
		agents.add(a);
	}
}

void draw() {
	background(22);
	drawGrid(20, 10);

	for (int i = 0; i < agents.size(); i ++) {
		Agent a = agents.get(i);
		update(a);
		if (isOutOfBounds(a, width, height)) {
			agents.remove(i);
		} else { 
			ellipse(a.getX(), a.getY(), 20, 20);
			if (drawPaths) {
				drawPath(a);
			}
		}
	}
}

void drawPath(Agent a) {
	for (int j = 0; j < a.path.size() - 1; j ++) {
		PVector p = a.path.get(j);
		PVector p1 = a.path.get(j + 1);
		line(p.x, p.y, p1.x, p1.y);
	}
}

void drawGrid(int gridWidth, int gridHeight) {
	for (int i = 0; i < width; i += width/gridWidth) {
		line(i, 0, i, height);
	}

	for (int i = 0; i < height; i += height/gridHeight) {
		line(0, i, width, i);
	}
}

boolean isOutOfBounds(Agent a, int width, int height) {
	return (a.getX() < 0 || a.getX() > width || a.getY() > height || a.getY() < 0); 
}

void update(Agent a) {
	a.move();
}

void keyPressed() {
	if (key == 'p') {
		drawPaths = !drawPaths;
	}
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