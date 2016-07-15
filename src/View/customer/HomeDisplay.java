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


public class HomeDisplay extends JPanel implements ActionListener {

	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int screenWidth = screenSize.width;
	private int screenHeight = screenSize.height;
	
	private JFrame frame;
	private Image bg;
	private JLabel lblICON;
	
	public HomeDisplay(JFrame frame){
		this.frame = frame;
		initHomeDisplay();
	}
	
	private void initHomeDisplay(){
		
		setPreferredSize(new Dimension(screenWidth, screenHeight));
		setBackground(Color.WHITE);
		setLayout(null);
		
		lblICON = new JLabel();
		lblICON.setIcon(new ImageIcon("img/logo_chocolate2.png"));
		lblICON.setBounds(20, 10, 200, 120);
		add(lblICON);
		
		JButton btnMENU = new JButton();
		btnMENU.setContentAreaFilled(false);
		btnMENU.setBorderPainted(false);
		btnMENU.setIcon(new ImageIcon("img/button-01.png"));
		btnMENU.setForeground(Color.WHITE);
		btnMENU.setBounds(95, 150, 330, 255);
		add(btnMENU);
		
		btnMENU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Menu();
				frame.dispose();
			}
		});
		
		JButton btnMYORDER = new JButton();
		btnMYORDER.setContentAreaFilled(false);
		btnMYORDER.setBorderPainted(false);
		btnMYORDER.setIcon(new ImageIcon("img/button-06.png"));
		btnMYORDER.setForeground(Color.WHITE);
		btnMYORDER.setBounds(510, 150, 330, 255);
		add(btnMYORDER);
		
		btnMYORDER.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				new Menu());
				frame.dispose();
			}
		});
		
		
		JButton btnFP = new JButton();
		btnFP.setContentAreaFilled(false);
		btnFP.setBorderPainted(false);
		btnFP.setIcon(new ImageIcon("img/button2-01.png"));
		btnFP.setForeground(Color.WHITE);
		btnFP.setBounds(925, 150, 330, 255);
		add(btnFP);
		
		btnFP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				new Menu());
				frame.dispose();
			}
		});
		
		JButton btnMYACC = new JButton();
		btnMYACC.setContentAreaFilled(false);
		btnMYACC.setBorderPainted(false);
		btnMYACC.setIcon(new ImageIcon("img/button-04.png"));
		btnMYACC.setForeground(Color.WHITE);
		btnMYACC.setBounds(95, 450, 330, 255);
		add(btnMYACC);
		
		btnMYACC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				new Menu());
				frame.dispose();
			}
		});
		
		JButton btnBack = new JButton();
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		btnBack.setIcon(new ImageIcon("img/back.png"));
		btnBack.setForeground(Color.WHITE);
		btnBack.setBounds(1146, 50, 109, 46);
		add(btnBack);
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new WelcomeLogin();
				frame.dispose();
			}
		});
		
		JButton btnGAMES = new JButton();
		btnGAMES.setContentAreaFilled(false);
		btnGAMES.setBorderPainted(false);
		btnGAMES.setIcon(new ImageIcon("img/button-03.png"));
		btnGAMES.setForeground(Color.WHITE);
		btnGAMES.setBounds(510, 450, 330, 255);
		add(btnGAMES);
		
		btnGAMES.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				new Menu());
				frame.dispose();
			}
		});
		
		JButton btnCALL = new JButton();
		btnCALL.setContentAreaFilled(false);
		btnCALL.setBorderPainted(false);
		btnCALL.setIcon(new ImageIcon("img/button2-04.png"));
		btnCALL.setForeground(Color.WHITE);
		btnCALL.setBounds(925, 450, 330, 255);
		add(btnCALL);
		
		btnCALL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				new Menu());
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
