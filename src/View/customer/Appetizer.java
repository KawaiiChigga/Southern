package View.customer;

import javax.swing.JFrame;

public class Appetizer extends JFrame{

	public Appetizer(){
		initAppetizer();
	}
	
	private void initAppetizer(){
		add(new AppetizerDisplay(this));
		setResizable(false);
		pack();
		
		setTitle("Southern");
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
