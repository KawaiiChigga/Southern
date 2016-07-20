package View.customer;

import javax.swing.JFrame;

import Model.Table;

public class FoodProcess extends JFrame{
	private Table customer;
	public FoodProcess(Table customer){
		this.customer = customer;
		initFoodProcess();
	}
	
	private void initFoodProcess(){
		add(new FoodProcessDisplay(this, customer));
		setResizable(false);
		pack();
		
		setTitle("Southern");
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
