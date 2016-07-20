package View.customer;

import javax.swing.JFrame;

import Model.Table;

public class TypeMenu extends JFrame{
	private Table customer;
	private String tipeMenu;
	public TypeMenu(String tipeMenu, Table customer){
		this.customer = customer;
		this.tipeMenu = tipeMenu;
		initAppetizer();
	}
	
	private void initAppetizer(){
		add(new TypeMenuDisplay(this, tipeMenu, customer));
		setResizable(false);
		pack();
		
		setTitle("Southern");
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
