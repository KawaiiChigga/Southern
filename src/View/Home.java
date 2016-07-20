package View;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Model.Staff;
import Model.Table;
import View.customer.HomeDisplay;
import View.staff.VCashier;
import View.staff.VChef;
import View.staff.VWaiter;

public class Home extends JFrame {
	
	private Staff stf;
	private Table customer;
	public Home(Staff stf){
		this.stf = stf;
		initHome();
	}
	public Home(Table customer) {
		this.customer = customer;
		initHome();
	}
	private void initHome(){
		if (stf != null) {
			if (stf.getStatus().equalsIgnoreCase("Waiter")) {
				add(new VWaiter(this, stf));
			} else if (stf.getStatus().equalsIgnoreCase("Chef")) {
				add(new VChef(this, stf));
			} else if (stf.getStatus().equalsIgnoreCase("Cashier")) {
				add(new VCashier(this, stf));
			}
		} else {
			if (customer == null) {
				String no_meja = "";
//				while(no_meja.equals("") || no_meja.length() != 5 || !no_meja.substring(0, 1).equalsIgnoreCase("T")) {
//					no_meja = JOptionPane.showInputDialog(null, "Table Number <TXXXX> : ", "DEMO", JOptionPane.INFORMATION_MESSAGE);
//				}
				customer = new Table();
				customer.setNo_meja("T0001");
			}
			add(new HomeDisplay(this, customer));
		}
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		
		setTitle("Southern");
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
