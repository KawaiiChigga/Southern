package View;

import javax.swing.JFrame;

import Model.Staff;
import View.customer.HomeDisplay;

public class Home extends JFrame {
	
	private Staff stf;
	public Home(Staff stf){
		this.stf = stf;
		initHome();
	}
	
	private void initHome(){
		if (stf.getStatus().equalsIgnoreCase("Waiter")) {
			
		} else if (stf.getStatus().equalsIgnoreCase("Chef")) {
			
		} else if (stf.getStatus().equalsIgnoreCase("Cashier")) {
			
		} else {
			add(new HomeDisplay(this));
		}
		setResizable(false);
		pack();
		
		setTitle("Southern");
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
