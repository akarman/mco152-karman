package karman.physics;
public class Parabola {
	
	private int angle;
	private int velocity;
	
	public Parabola(int angle, int velocity){
		this.angle=angle;
		this.velocity=velocity;
	}

	public static void main(String[] args){

		Parabola aPar= new Parabola(37,73);
		aPar.calculateCurve( 0,  10);
	}

	public double calculateX(int time){
		double x= Math.cos(Math.toRadians(angle))*velocity*time ;
		return x;
	}

	public double calculateY(int time){
		double y=Math.sin(Math.toRadians(angle))*velocity*(time)+(.5)*(-9.8)*(time*time);
		return y;
	}

	public void calculateCurve(int startTime, int endTime){
		for(int time=startTime; time<=endTime; time++){
			System.out.println("Time: "+ time + "\tx: " + calculateX(time)
					+ "\ty: " + calculateY(time));
		}
	}

}