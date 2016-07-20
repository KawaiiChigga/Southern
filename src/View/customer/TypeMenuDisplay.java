package View.customer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Control.CtrlMenuList;
import Main.WelcomeLogin;
import Model.Menu;
import View.customer.Menus;
import Model.Transaction;

public class TypeMenuDisplay extends JPanel {

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int screenWidth = screenSize.width;
	private int screenHeight = screenSize.height;

	private JFrame frame;
	private JLabel lblICON, lblBROWN1, lblBROWN2, lblORANGE, lbl0Name, lbl0Img, lbl0Price, lbl0Ex;
	private JButton btn0, btnBack;
	private JTextField count;
	private String tipeMenu;
	
	public TypeMenuDisplay(JFrame frame, String tipeMenu) {
		this.frame = frame;
		this.tipeMenu = tipeMenu;
		initAppetizerDisplay();
	}

	private void initAppetizerDisplay() {
		setPreferredSize(new Dimension(screenWidth, screenHeight));
		setBackground(Color.WHITE);
		setLayout(null);

		List<Menu> listM = CtrlMenuList.getMenuList(tipeMenu);
		String mName = listM.get(0).getMenu_name();
		String mImg = listM.get(0).getUrl();
		double mPrice = listM.get(0).getPrice();
		int mPricee = (int) mPrice;
		String mEx = listM.get(0).getExplanation();

		lblICON = new JLabel();
		lblICON.setIcon(new ImageIcon("img/logo_chocolate2.png"));
		lblICON.setBounds(20, 10, 200, 120);
		add(lblICON);

		btnBack = new JButton();
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		btnBack.setIcon(new ImageIcon("img/back.png"));
		btnBack.setForeground(Color.WHITE);
		btnBack.setBounds(1146, 50, 109, 46);
		add(btnBack);
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Menus();
				frame.dispose();
			}
		});
		
		lbl0Name = new JLabel('"' + mName + '"');
		lbl0Name.setFont(new Font("Franchise", Font.PLAIN, 30));
		lbl0Name.setForeground(Color.WHITE);
		lbl0Name.setBounds(135, 120, 330, 120);
		add(lbl0Name);

		lbl0Img = new JLabel();
		lbl0Img.setIcon(new ImageIcon(mImg));
		lbl0Img.setBounds(170, 220, 168, 200);
		add(lbl0Img);
		
		lbl0Ex = new JLabel(mEx);
		lbl0Ex.setFont(new Font("Franchise", Font.PLAIN, 20));
		lbl0Ex.setForeground(Color.WHITE);
		lbl0Ex.setBounds(120, 400, 330, 120);
		add(lbl0Ex);

		lbl0Price = new JLabel(mPricee+ "");
		lbl0Price.setFont(new Font("The Heart of Everything Demo", Font.PLAIN, 40));
		lbl0Price.setForeground(Color.WHITE);
		lbl0Price.setBounds(200, 450, 330, 120);
		add(lbl0Price);
		
		count = new JTextField();
		count.setFont(new Font("Franchise", Font.PLAIN, 40));
		count.setBounds(250, 553, 109, 40);
		add(count);
		
		btn0 = new JButton();
		btn0.setContentAreaFilled(false);
		btn0.setBorderPainted(false);
		btn0.setIcon(new ImageIcon("img/back.png"));
		btn0.setForeground(Color.WHITE);
		btn0.setBounds(150, 550, 109, 46);
		add(btn0);
		
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		lblBROWN1 = new JLabel();
		lblBROWN1.setIcon(new ImageIcon("img/brown.jpg"));
		lblBROWN1.setBounds(95, 150, 330, 510);
		add(lblBROWN1);

		lblORANGE = new JLabel();
		lblORANGE.setIcon(new ImageIcon("img/orange.jpg"));
		lblORANGE.setBounds(510, 150, 330, 510);
		add(lblORANGE);

		lblBROWN2 = new JLabel();
		lblBROWN2.setIcon(new ImageIcon("img/brown.jpg"));
		lblBROWN2.setBounds(925, 150, 330, 510);
		add(lblBROWN2);

	}

}
