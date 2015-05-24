import java.util.ArrayList;
public class Agent1 {
	private int x;
	private int y;
	private int momentumX;
	private int momentumY;
	private int destX;
	private int destY;
	//ArrayList<PVector> path = new ArrayList<PVector>();

	public Agent1(int x, int y, int destX, int destY) {
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
	}
}
