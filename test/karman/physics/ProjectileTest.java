package karman.physics;

import static junit.framework.Assert.assertEquals;

import java.awt.Color;

import org.junit.Test;

import junit.framework.Assert;

public class ProjectileTest {

	//test methods, not getters and setters
	
	@Test
	public void testGetX(){		
		Projectile p = new Projectile(-323, 73, Color.RED);
		assertEquals(291.5, p.getX(5),.1);
	}
	
	@Test
	public void testGetY(){
		Projectile p= new Projectile(-323, 73, Color.RED);
		assertEquals(97.1, p.getY(5), .1);
	}
}
