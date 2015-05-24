public class Agent {
	private int x;
	private int y;
	private int momentumX;
	private int momentumY;

	public Agent(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
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