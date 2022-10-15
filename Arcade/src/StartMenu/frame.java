package StartMenu;

import javax.swing.*;

public class frame extends JFrame{
	public frame(){
		this.add(new panel());
		this.setTitle("ARCADE");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}
