package karman.physics;

import java.awt.Color;

public class Projectile {
	
	//private for data encapsulation
	private double angle;
	private double velocity;
	private Color color;
	
	
	public Projectile(double angle, double velocity, Color color) {
		this.angle = angle;
		this.velocity = velocity;
		this.color=color;
	}
	
	public double getX(double time){
		return Math.cos(Math.toRadians(angle)) * velocity *  time;
	}
	
	public double getY(double time){
		return Math.sin(Math.toRadians(angle))* velocity * time +.5*-9.8*(time * time);
	}
	public double getAngle(){
		return angle;
	}
	
	public Color getColor(){
		return color;
	}

	
	
	
	

}
