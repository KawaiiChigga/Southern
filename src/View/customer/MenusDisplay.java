package View.customer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Main.WelcomeLogin;
import Model.Table;
import View.Home;


public class MenusDisplay extends JPanel implements ActionListener {

	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int screenWidth = screenSize.width;
	private int screenHeight = screenSize.height;
	
	private JFrame frame;
	private Image bg;
	private JLabel lblICON;
	private JButton btnBack;
	private Table customer;
	
	public MenusDisplay(JFrame frame, Table customer){
		this.customer = customer;
		this.frame = frame;
		initMenuDisplay();
	}
	
	private void initMenuDisplay(){
		
		setPreferredSize(new Dimension(screenWidth, screenHeight));
		setBackground(Color.WHITE);
		setLayout(null);
		
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
				new Home(customer);
				frame.dispose();
			}
		});
		
		JButton btnAPP = new JButton();
		btnAPP.setContentAreaFilled(false);
		btnAPP.setBorderPainted(false);
		btnAPP.setIcon(new ImageIcon("img/type-01.png"));
		btnAPP.setForeground(Color.WHITE);
		btnAPP.setBounds(295, 150, 330, 255);
		add(btnAPP);
		
		btnAPP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TypeMenu("Appetizer");
				frame.dispose();
			}
		});
		
		JButton btnMC = new JButton();
		btnMC.setContentAreaFilled(false);
		btnMC.setBorderPainted(false);
		btnMC.setIcon(new ImageIcon("img/type-03.png"));
		btnMC.setForeground(Color.WHITE);
		btnMC.setBounds(710, 150, 330, 255);
		add(btnMC);
		
		btnMC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TypeMenu("Main Course");
				frame.dispose();
			}
		});
		
		
		JButton btnDESS = new JButton();
		btnDESS.setContentAreaFilled(false);
		btnDESS.setBorderPainted(false);
		btnDESS.setIcon(new ImageIcon("img/type-04.png"));
		btnDESS.setForeground(Color.WHITE);
		btnDESS.setBounds(295, 450, 330, 255);
		add(btnDESS);
		
		btnDESS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TypeMenu("Dessert");
				frame.dispose();
			}
		});
		
		JButton btnDRINKS = new JButton();
		btnDRINKS.setContentAreaFilled(false);
		btnDRINKS.setBorderPainted(false);
		btnDRINKS.setIcon(new ImageIcon("img/type-02.png"));
		btnDRINKS.setForeground(Color.WHITE);
		btnDRINKS.setBounds(710, 450, 330, 255);
		add(btnDRINKS);
		
		btnDRINKS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TypeMenu("Drinks");
				frame.dispose();
			}
		});
		
	}

	
	@Override
	public void actionPerformed(ActionEvent arg0) {

		repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(bg, 0, 0, this);
		
		Toolkit.getDefaultToolkit().sync();
	}
	
}
