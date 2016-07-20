package View;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
			String tbl_number = "";
			//while(tbl_number.equals("") || tbl_number.length() != 5 || !tbl_number.substring(0, 1).equalsIgnoreCase("T")) {
			//	tbl_number = JOptionPane.showInputDialog(null, "Table Number <TXXXX> : ", "DEMO", JOptionPane.INFORMATION_MESSAGE);
		//	}
			add(new HomeDisplay(this, tbl_number));
		}
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		
		setTitle("Southern");
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
