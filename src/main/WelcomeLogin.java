package main;

import javax.swing.JFrame;

import cutomer.Home;
import cutomer.Menu;
import cutomer.WelcomeLoginDisplay;

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
		new Menu();
	}
	
}
