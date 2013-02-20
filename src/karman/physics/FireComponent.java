package karman.physics;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JComponent;

public class FireComponent extends JComponent {

	private LinkedList<Projectile> list;
	private Random random;

	public FireComponent() {

		random = new Random();
		list = new LinkedList<Projectile>();
		addProjectiles();
	}

	private int getRandomAngle() {
		return 45 + random.nextInt(90);
	}

	private int getRandomVelocity() {
		return 40 + random.nextInt(40);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.translate(getWidth() / 2, getHeight() / 2);
		
		Graphics2D g2=(Graphics2D)g;
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .1f));

		addProjectiles();

		Iterator<Projectile> iter = list.iterator();
		Projectile projectile;
		while (iter.hasNext()) {
			projectile = iter.next();
			int x = (int) projectile.getX();
			int y = (int) projectile.getY();

			g.setColor(projectile.getFireColor());
			int size = 5;

			g.fillOval(x - size / 2, -y - (size / 2), size, size);

			projectile.tick();

			if (projectile.getTime() > .6) {
				iter.remove();
			}
		}

		this.repaint();
	}

	private void addProjectiles() {
		if (list.size() < 5000) {
			for (int i = 0; i < 10; i++) {
				list.add(new Projectile(getRandomAngle(), getRandomVelocity(),
						Color.WHITE));
			}
		}

	}

}