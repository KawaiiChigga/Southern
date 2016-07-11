package cutomer;

import javax.swing.JFrame;

public class Menu extends JFrame{

	public Menu(){
		initMenu();
	}
	
	private void initMenu(){
		add(new MenuDisplay(this));
		setResizable(false);
		pack();
		
		setTitle(null);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
