package karman.physics;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class FireGui extends JFrame {

	public FireGui() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("FIRE");
		setSize(800, 600);
		setLayout(new BorderLayout());

		add(new FireComponent(), BorderLayout.CENTER);

		setVisible(true);

	}
	
	public static void main(String[] args){
		new FireGui(); 
	}

}
