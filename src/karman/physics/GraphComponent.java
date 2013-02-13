package karman.physics;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JComponent;

public class GraphComponent extends JComponent {

	private ArrayList<Projectile> p;
	private double time = 0;
	private Random random;

	public GraphComponent() {

		random = new Random();
		p = new ArrayList<Projectile>();

		for (int i = 0; i < 10; i++) {
			p.add(new Projectile(getRandomAngle(), getRandomVelocity(),
					getRandomColor()));
		}
	}

	private Color getRandomColor() {
		// create a random color
		int red = random.nextInt(256);
		int green = random.nextInt(256);
		int blue = random.nextInt(256);
		return new Color(red, green, blue);
	}

	private int getRandomAngle() {
		return random.nextInt(360);
	}

	private int getRandomVelocity() {
		return 200 + random.nextInt(500);
	}

	@Override
	// override a method called paintComponent and in that we will do ALL our
	// draw calls-
	// or call methods that draw
	// screen is Graphics
	protected void paintComponent(Graphics g) {
		
		//draw a grid
		
		for(double i=0; i<getHeight(); i+=.5){
			g.drawLine(0, (int)i, getWidth(), (int)i);
		}
		

		g.translate(getWidth() / 2, getHeight() / 2);

		time += .001;

		for (Projectile aProj : p) {

			g.setColor(aProj.getColor());

			int x = (int) aProj.getX(time);
			int y = (int) aProj.getY(time);
			int size = 20;
			g.fillOval(x - (size / 2), -y - (size / 2), size, size);
			// don't recalculate x and y, store into a variable
			// g.drawLine(x, -y, (int) aProj.getX(time - 1),
			// (int) -aProj.getY(time - 1));

			this.repaint();

		}

	}

}
