package Main;

import javax.swing.JFrame;

import Control.CtrlStaff;
import View.customer.Home;
import View.customer.WelcomeLoginDisplay;

public class WelcomeLogin extends JFrame{

	public WelcomeLogin(){
		initWelcomeLogin();
	}
	
	private void initWelcomeLogin(){
		add(new WelcomeLoginDisplay(this));
		setResizable(false);
		pack();
		setTitle("Southern");
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public static <T> T Calculate (T a[])
	{
		T tes = a[0];
		return tes;
	}
	public static void main(String[] args){
		new WelcomeLogin();
	}
	
}
