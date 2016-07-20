package View.customer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Control.CtrlMenuList;
import Main.WelcomeLogin;
import Model.Menu;
import Model.Table;
import View.customer.Menus;
import Model.Transaction;

public class TypeMenuDisplay extends JPanel {

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int screenWidth = screenSize.width;
	private int screenHeight = screenSize.height;

	private JFrame frame;
	private JLabel lblICON, lblBROWN1, lblBROWN2, lblORANGE;

	private JLabel lbl0Name, lbl0Img, lbl0Price, lbl0Ex;
	private JLabel lbl1Name, lbl1Img, lbl1Price, lbl1Ex;
	private JLabel lbl2Name, lbl2Img, lbl2Price, lbl2Ex;
	private List<Menu> listM;
	private JButton btn0, btn1, btn2, btnBack;
	private JComboBox count0, count1, count2;
	private String tipeMenu;
	private Table customer;

	public TypeMenuDisplay(JFrame frame, String tipeMenu, Table customer) {
		this.customer = customer;
		this.frame = frame;
		this.tipeMenu = tipeMenu;
		initTypeMenuDisplay();
	}

	private void initTypeMenuDisplay() {
		setPreferredSize(new Dimension(screenWidth, screenHeight));
		setBackground(Color.WHITE);
		setLayout(null);

		listM = CtrlMenuList.getMenuList(tipeMenu);

		String mName0 = listM.get(0).getMenu_name();
		String mImg0 = listM.get(0).getUrl();
		double mPrice0 = listM.get(0).getPrice();
		int mPricee0 = (int) mPrice0;
		String mEx0 = listM.get(0).getExplanation();

		String mName1 = listM.get(1).getMenu_name();
		String mImg1 = listM.get(1).getUrl();
		double mPrice1 = listM.get(1).getPrice();
		int mPricee1 = (int) mPrice1;
		String mEx1 = listM.get(1).getExplanation();

		String mName2 = listM.get(2).getMenu_name();
		String mImg2 = listM.get(2).getUrl();
		double mPrice2 = listM.get(2).getPrice();
		int mPricee2 = (int) mPrice2;
		String mEx2 = listM.get(2).getExplanation();

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
				new Menus(customer);
				frame.dispose();
			}
		});

		lbl0Name = new JLabel('"' + mName0 + '"');
		lbl0Name.setFont(new Font("Franchise", Font.PLAIN, 30));
		lbl0Name.setForeground(Color.WHITE);
		lbl0Name.setBounds(135, 120, 330, 120);
		add(lbl0Name);

		lbl0Img = new JLabel();
		lbl0Img.setIcon(new ImageIcon(mImg0));
		lbl0Img.setBounds(170, 220, 200, 200);
		add(lbl0Img);

		lbl0Ex = new JLabel(mEx0);
		lbl0Ex.setFont(new Font("Franchise", Font.PLAIN, 20));
		lbl0Ex.setForeground(Color.WHITE);
		lbl0Ex.setBounds(120, 400, 330, 120);
		add(lbl0Ex);

		lbl0Price = new JLabel(mPricee0 + "");
		lbl0Price.setFont(new Font("The Heart of Everything Demo", Font.PLAIN, 40));
		lbl0Price.setForeground(Color.WHITE);
		lbl0Price.setBounds(200, 450, 330, 120);
		add(lbl0Price);

		Object[] countPilih = { 0, 1, 2, 3, 4, 5 };
		count0 = new JComboBox(countPilih);
		count0.setFont(new Font("The Heart of Everything Demo", Font.PLAIN, 15));
		count0.setBounds(250, 553, 50, 40);
		add(count0);

		btn0 = new JButton();
		btn0.setContentAreaFilled(false);
		btn0.setBorderPainted(false);
		btn0.setIcon(new ImageIcon("img/order_orange-01.png"));
		btn0.setForeground(Color.WHITE);
		btn0.setBounds(150, 550, 109, 46);
		add(btn0);

		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				order(0);
				count0.setSelectedIndex(0);
			}
		});

		lblBROWN1 = new JLabel();
		lblBROWN1.setIcon(new ImageIcon("img/brown.jpg"));
		lblBROWN1.setBounds(95, 150, 330, 510);
		add(lblBROWN1);

		lbl1Name = new JLabel('"' + mName1 + '"');
		lbl1Name.setFont(new Font("Franchise", Font.PLAIN, 30));
		lbl1Name.setForeground(Color.WHITE);
		lbl1Name.setBounds(560, 120, 330, 120);
		add(lbl1Name);

		lbl1Img = new JLabel();
		lbl1Img.setIcon(new ImageIcon(mImg1));
		lbl1Img.setBounds(570, 220, 200, 200);
		add(lbl1Img);

		lbl1Ex = new JLabel(mEx1);
		lbl1Ex.setFont(new Font("Franchise", Font.PLAIN, 20));
		lbl1Ex.setForeground(Color.WHITE);
		lbl1Ex.setBounds(560, 400, 330, 120);
		add(lbl1Ex);

		lbl1Price = new JLabel(mPricee1 + "");
		lbl1Price.setFont(new Font("The Heart of Everything Demo", Font.PLAIN, 40));
		lbl1Price.setForeground(Color.WHITE);
		lbl1Price.setBounds(560, 450, 330, 120);
		add(lbl1Price);

		Object[] countPilih1 = { 0, 1, 2, 3, 4, 5 };
		count1 = new JComboBox(countPilih);
		count1.setFont(new Font("The Heart of Everything Demo", Font.PLAIN, 15));
		count1.setBounds(660, 553, 50, 40);
		add(count1);

		btn1 = new JButton();
		btn1.setContentAreaFilled(false);
		btn1.setBorderPainted(false);
		btn1.setIcon(new ImageIcon("img/order_chocolate-01.png"));
		btn1.setForeground(Color.WHITE);
		btn1.setBounds(560, 550, 109, 46);
		add(btn1);

		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				order(1);
				count1.setSelectedIndex(0);
			}
		});

		lblORANGE = new JLabel();
		lblORANGE.setIcon(new ImageIcon("img/orange.jpg"));
		lblORANGE.setBounds(510, 150, 330, 510);
		add(lblORANGE);

		lbl2Name = new JLabel('"' + mName2 + '"');
		lbl2Name.setFont(new Font("Franchise", Font.PLAIN, 30));
		lbl2Name.setForeground(Color.WHITE);
		lbl2Name.setBounds(975, 120, 330, 120);
		add(lbl2Name);

		lbl2Img = new JLabel();
		lbl2Img.setIcon(new ImageIcon(mImg2));
		lbl2Img.setBounds(975, 220, 200, 200);
		add(lbl2Img);

		lbl2Ex = new JLabel(mEx2);
		lbl2Ex.setFont(new Font("Franchise", Font.PLAIN, 20));
		lbl2Ex.setForeground(Color.WHITE);
		lbl2Ex.setBounds(975, 400, 330, 120);
		add(lbl2Ex);

		lbl2Price = new JLabel(mPricee2 + "");
		lbl2Price.setFont(new Font("The Heart of Everything Demo", Font.PLAIN, 40));
		lbl2Price.setForeground(Color.WHITE);
		lbl2Price.setBounds(975, 450, 330, 120);
		add(lbl2Price);

		Object[] countPilih2 = { 0, 1, 2, 3, 4, 5 };
		count2 = new JComboBox(countPilih);
		count2.setFont(new Font("The Heart of Everything Demo", Font.PLAIN, 15));
		count2.setBounds(1075, 553, 50, 40);
		add(count2);

		btn2 = new JButton();
		btn2.setContentAreaFilled(false);
		btn2.setBorderPainted(false);
		btn2.setIcon(new ImageIcon("img/order_orange-01.png"));
		btn2.setForeground(Color.WHITE);
		btn2.setBounds(975, 550, 109, 46);
		add(btn2);

		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				order(2);
				count2.setSelectedIndex(0);
			}
		});

		lblBROWN2 = new JLabel();
		lblBROWN2.setIcon(new ImageIcon("img/brown.jpg"));
		lblBROWN2.setBounds(925, 150, 330, 510);
		add(lblBROWN2);

	}

	private void order(int x) {
		int count = 0;
		if (x == 0) {
			count = count0.getSelectedIndex();
		} else if (x == 1) {
			count = count1.getSelectedIndex();
		} else if (x == 2) {
			count = count2.getSelectedIndex();
		}
		if (customer.getMyOrder() == null) {
			customer.setOrder(new ArrayList());
		}
		for (int i = 0; i < count; i++) {
			Menu m = CtrlMenuList.getMenu(listM.get(x).getMenu_id());
			customer.setMyOrder(m);
		}
		System.out.println("====PRINT====");
		for (int i = 0; i < customer.getMyOrder().size(); i++) {
			System.out.println(customer.getMyOrder().get(i).getMenu_name());
		}
	}
}
