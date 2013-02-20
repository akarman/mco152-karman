package karman.physics;

import java.awt.Color;

public class Projectile {
	
	//private for data encapsulation
	private double angle;
	private double velocity;
	private Color color;
	private double time;
	
	
	public Projectile(double angle, double velocity, Color color) {
		this.angle = angle;
		this.velocity = velocity;
		this.color=color;
		this.time=0.000;
	}
	
	public double getX(){
		return Math.cos(Math.toRadians(angle)) * velocity *  time;
	}
	
	public double getY(){
		return Math.sin(Math.toRadians(angle))* velocity * time +.5*-9.8*(time * time);
	}
	public double getAngle(){
		return angle;
	}
	
	public Color getColor(){
		return color;
	}
	
	public void tick(){
		time+=.001;
	}
	
	public double getTime(){
		return time;
	}

	public Color getFireColor() {
		if(time>=0&&time<=.2)
			return Color.WHITE;
		if(time>.2&&time<=.4)
			return Color.YELLOW;
		if(time>.4&&time<.6)
			return Color.RED;
		else return Color.GRAY;
	}

	
	
	
	

}
