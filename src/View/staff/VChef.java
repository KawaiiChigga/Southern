package View.staff;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Model.Staff;

public class VChef extends JPanel{
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int screenWidth = screenSize.width;
	private int screenHeight = screenSize.height;
	private Staff stf;
	
	public VChef(JFrame frame, Staff stf){
		this.stf = stf;
		this.frame = frame;
		initVChef();
	}

	private void initVChef() {
		// TODO Auto-generated method stub
		setPreferredSize(new Dimension(screenWidth, screenHeight));
		setBackground(Color.WHITE);
		setLayout(null);
		
		bill = new JButton();
		bill.setText("Bill");
		bill.setBounds(600, 100, 100, 30);
		
		checkTrans = new JButton();
		checkTrans.setText("Check Transaction");
		checkTrans.setBounds(300, 100, 200, 30);
		
		add(bill);
		add(checkTrans);
	}
	private JButton bill;
	private JButton checkTrans;
	private JFrame frame;
	private Image bg;
}
