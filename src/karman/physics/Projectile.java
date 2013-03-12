package karman.physics;

import java.awt.Color;

public class Projectile {
	
	//private for data encapsulation
	private double angle;
	private double velocity;
	private Color color;
	private int size;
	private double lifespan;
	private double startTime;
	private double sin;
	private double cos;
	private int startX;
	private int startY;
	
	
	public Projectile(double angleDegrees, double velocity, Color color,
			int size, double lifespan, double startTime, int x, int y) {
		this.angle = Math.toRadians(angleDegrees);
		this.velocity = velocity;
		this.color = color;
		this.size = size;
		this.lifespan = lifespan;
		this.startTime = startTime;
		sin = Math.sin(angle);
		cos = Math.cos(angle);
		this.startX = x;
		this.startY = y;
	}
	
	public double getX(double time){
		return cos * velocity *  time + startX;
	}
	
	public double getY(double time){
		return sin * velocity * time + (.5 * -9.8 * time * time) + startY;
	}
	public double getAngle(){
		return angle;
	}
	
	public Color getColor(){
		return color;
	}
	
	public void setStartTime(double startTime){
		this.startTime=startTime;
	}
	
	public double getStartTime() {
		return startTime;
	}

	public int getStartX() {
		return startX;
	}

	public void setStartX(int startX) {
		this.startX = startX;
	}

	public int getStartY() {
		return startY;
	}

	public void setStartY(int startY) {
		this.startY = startY;
	}

	public double getVelocity() {
		return velocity;
	}

	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public double getLifespan() {
		return lifespan;
	}

	
	
	
	
	

}
