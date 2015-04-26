import Support.DrawingPanel;
import java.awt.Graphics;
import java.util.list.ArrayList;

public class SidewalkMain {
	public static void main(String[] args) {
		DrawingPanel panel = new DrawingPanel(500, 500);
		Graphics g = panel.getGraphics();
		
		ArrayList
	}

	public static void redraw(ArrayList<Agent> agents) {
		for (Agent a : agents) {
			g.drawOval(10, 5, agents.getX(), agents.getY());
		}
	}
}

