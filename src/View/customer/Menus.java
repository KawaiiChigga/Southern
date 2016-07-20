package View.customer;

import javax.swing.JFrame;

import Model.Table;

public class Menus extends JFrame {
	private Table customer;
	public Menus(Table customer){
		this.customer = customer;
		initMenu();
	}
	
	private void initMenu(){
		add(new MenusDisplay(this, customer));
		setResizable(false);
		pack();
		
		setTitle("Southern");
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
