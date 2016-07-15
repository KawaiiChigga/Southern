package View.staff;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VCashier extends JPanel{
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int screenWidth = screenSize.width;
	private int screenHeight = screenSize.height;
	
	public VCashier(JFrame frame){
		this.frame = frame;
		initVCashier();
	}

	private void initVCashier() {
		// TODO Auto-generated method stub
		setPreferredSize(new Dimension(screenWidth, screenHeight));
		setBackground(Color.WHITE);
		setLayout(null);
		
		bill = new JButton();
		bill.setText("Bill");
		bill.setBounds(200, 200, 200, 200);
		
		checkTrans = new JButton();
		checkTrans.setText("Check Transaction");
		checkTrans.setBounds(600, 200, 200, 200);
		
		add(bill);
		add(checkTrans);
	}
	private JButton bill;
	private JButton checkTrans;
	private JFrame frame;
	private Image bg;
}
