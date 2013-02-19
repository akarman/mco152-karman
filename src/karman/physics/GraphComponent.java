package karman.physics;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JComponent;

public class GraphComponent extends JComponent {

	private Projectile[] p;
	private Random random;

	public GraphComponent() {

		random = new Random();
		p = new Projectile[10];

		for (int i = 0; i < p.length; i++) {
			p[i]=new Projectile(getRandomAngle(), getRandomVelocity(),
					getRandomColor());
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

	private void drawGrid(Graphics g) {
		// draw a grid

		for (int i = 0; i < getHeight(); i += 20) {
			g.drawLine(0, i, getWidth(), i);
		}

		for (int i = 0; i < getWidth(); i += 20) {
			g.drawLine(i, 0, i, getHeight());
		}
	}

	@Override
	// override a method called paintComponent and in that we will do ALL our
	// draw calls-
	// or call methods that draw
	// screen is Graphics
	protected void paintComponent(Graphics g) {

		drawGrid(g);
		g.translate(getWidth() / 2, getHeight() / 2);

		for (int i=0; i<p.length;i++) {

			//calculate x and y
			int x = (int) p[i].getX(p[i].getTime());
			int y = (int) p[i].getY(p[i].getTime());
			
			
			g.setColor(p[i].getColor());
			int size = 30;
			g.fillOval(x - (size / 2), -y - (size / 2), size, size);
			
			//advance by one tick and check
			//if off-screen, instantiate a new projectile
			p[i].tick();
			x=(int) p[i].getX(p[i].getTime());
			y=(int) p[i].getY(p[i].getTime());
			if(x>this.getWidth()/2||x<-(getWidth()/2)||y>getHeight()/2||y<-(getHeight()/2)){
				p[i]=new Projectile(getRandomAngle(), getRandomVelocity(), getRandomColor());
			}
			this.repaint();
		}

	}

}
