package View;
import javax.swing.JFrame;

import Model.Staff;
import View.customer.HomeDisplay;
import View.staff.VCashier;
import View.staff.VChef;

public class Home extends JFrame {
	
	private Staff stf;
	public Home(Staff stf){
		this.stf = stf;
		initHome();
	}
	private void initHome(){
		if (stf != null) {
			if (stf.getStatus().equalsIgnoreCase("Waiter")) {
//				add(new VWaiter(this, stf));
			} else if (stf.getStatus().equalsIgnoreCase("Chef")) {
				add(new VChef(this, stf));
			} else if (stf.getStatus().equalsIgnoreCase("Cashier")) {
				add(new VCashier(this, stf));
			}
		} else {
			add(new HomeDisplay(this));
		}
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		
		setTitle("Southern");
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
