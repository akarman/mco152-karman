package karman.physics;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JComponent;

public class GraphComponent extends JComponent {

	private ArrayList<Projectile> p;

	public GraphComponent(ArrayList<Projectile> p) {
		this.p = p;
	}

	@Override
	// override a method called paintComponent and in that we will do ALL our
	// draw calls-
	// or call methods that draw
	// screen is Graphics
	protected void paintComponent(Graphics g) {
		// create a random generator

		Random randomColor = new Random();

		g.translate(0, getHeight());

		for (Projectile aProj : p) {

			// create a random color
			int red = randomColor.nextInt(255);
			int green = randomColor.nextInt(255);
			int blue = randomColor.nextInt(255);

			g.setColor(new Color(red, green, blue));

			for (int i = 0; i < 10; i++) {
				int x = (int) aProj.getX(i);
				int y = (int) aProj.getY(i);
				int size=20;
				g.drawOval(x-(size/2), -y-(size/2), size, size);
				//don't recalculate x and y, store into a variable
				g.drawLine(x, -y,
						(int) aProj.getX(i - 1), (int) -aProj.getY(i - 1));

			}
		}

	}

}
