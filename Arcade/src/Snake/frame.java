package Snake;

import javax.swing.JFrame;

public class frame extends JFrame{
	
	public frame(){
		this.add(new panel());
		this.setTitle("ARCADE -- Snake --");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

}
