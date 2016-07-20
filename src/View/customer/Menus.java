package View.customer;

import javax.swing.JFrame;

public class Menus extends JFrame {

	public Menus(){
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
