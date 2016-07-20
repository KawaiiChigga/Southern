package View.customer;

import javax.swing.JFrame;

import Model.Table;

public class MyOrder extends JFrame {
	private Table customer;
	public MyOrder(Table customer){
		this.customer = customer;
		initMyOrder();
	}
	
	private void initMyOrder(){
		add(new MyOrderDisplay(this, customer));
		setResizable(false);
		pack();
		
		setTitle("Southern");
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
