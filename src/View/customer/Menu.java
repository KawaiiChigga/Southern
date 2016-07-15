package View.customer;

import javax.swing.JFrame;

public class Menu extends JFrame {

	public Menu(){
		initMenu();
	}
	
	private void initMenu(){
		add(new MenuDisplay(this));
		setResizable(false);
		pack();
		
		setTitle("Southern");
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
