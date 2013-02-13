package karman.physics;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

public class ProjectileGui extends JFrame{
	
	public ProjectileGui(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Projectile GUI");
		setSize(800,600);
		
		
		setLayout(new BorderLayout());
		
		ArrayList<Projectile> p=new ArrayList<Projectile>();
		
		p.add(new Projectile(36.0, 73.0));
		p.add(new Projectile(45.0, 83.5));
		p.add(new Projectile(70.0, 120.0));
		p.add(new Projectile(45.0, 101.0));
		p.add(new Projectile(80.0, 57.0));
		
		add(new GraphComponent(p), BorderLayout.CENTER);
		
		
		
		setVisible(true);
	
	}
	
	public static void main(String[] args){
		new ProjectileGui();
	}

}
