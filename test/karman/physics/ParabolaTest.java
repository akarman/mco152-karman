package karman.physics;
import junit.framework.TestCase;
import karman.physics.Parabola;


public class ParabolaTest extends TestCase{
	
	
	private Parabola aPar= new Parabola(37,73);	
	
	public void testCalculateX(){
		assertEquals(aPar.calculateX(5),291.5,.1);
	}
	
	public void testCalculateY(){
		assertEquals(aPar.calculateY(5),97.1,.1);
	}
}