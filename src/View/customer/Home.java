package View.customer;

import javax.swing.JFrame;

public class Home extends JFrame {

	public Home(){
		initHome();
	}
	
	private void initHome(){
		add(new HomeDisplay(this));
		setResizable(false);
		pack();
		
		setTitle("Southern");
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
