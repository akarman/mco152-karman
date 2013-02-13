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
		
		
		
		
		add(new GraphComponent(), BorderLayout.CENTER);
		
		
		
		setVisible(true);
	
	}
	
	public static void main(String[] args){
		new ProjectileGui();
	}

}
