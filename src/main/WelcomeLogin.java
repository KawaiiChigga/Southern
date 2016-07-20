package main;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setTitle("Southern");
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args){
		new WelcomeLogin();
	}
}
