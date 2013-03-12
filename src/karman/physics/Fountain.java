package karman.physics;

import java.awt.Color;
import java.util.Random;

public class Fountain {

	private int x;
	private int y;
	private double startTime;
	private Random randomGen;

	public Fountain(int x, int y, double time) {
		this.x = x;
		this.y = y;
		this.startTime = time;

		randomGen = new Random();
	}

	public Projectile getProjectile() {
		return new Projectile((randomGen.nextInt(70) + 55),
				randomGen.nextInt(40) + 40, Color.WHITE,
				randomGen.nextInt(15) + 4, randomGen.nextInt(2) + 7, 0, x, y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getStartTime() {
		return startTime;
	}

	public void setStartTime(double startTime) {
		this.startTime = startTime;
	}

}
