package Main;

import javax.swing.JFrame;

import Control.CtrlStaff;
import View.WelcomeLoginDisplay;

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
	
	public static void main(String[] args){
		new WelcomeLogin();
	}
}
