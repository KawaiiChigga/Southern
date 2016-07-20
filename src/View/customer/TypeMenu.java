package View.customer;

import javax.swing.JFrame;

public class TypeMenu extends JFrame{

	private String tipeMenu;
	public TypeMenu(String tipeMenu){
		this.tipeMenu = tipeMenu;
		initAppetizer();
	}
	
	private void initAppetizer(){
		add(new TypeMenuDisplay(this, tipeMenu ));
		setResizable(false);
		pack();
		
		setTitle("Southern");
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
