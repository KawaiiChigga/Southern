package View.customer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Main.WelcomeLogin;
import Model.Table;
import View.Home;


public class MenusDisplay extends JPanel implements ActionListener, MouseListener {

	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int screenWidth = screenSize.width;
	private int screenHeight = screenSize.height;
	
	private JFrame frame;
	private Image bg;
	private JLabel lblICON;
	private JButton btnBack, btnAPP, btnMC, btnDESS, btnDRINKS;
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
		btnBack.addMouseListener(this);
		add(btnBack);
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Home(customer);
				frame.dispose();
			}
		});
		
		btnAPP = new JButton();
		btnAPP.setContentAreaFilled(false);
		btnAPP.setBorderPainted(false);
		btnAPP.setIcon(new ImageIcon("img/type-01.png"));
		btnAPP.setForeground(Color.WHITE);
		btnAPP.setBounds(295, 150, 330, 255);
		btnAPP.addMouseListener(this);
		add(btnAPP);
		
		btnAPP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TypeMenu("Appetizer", customer);
				frame.dispose();
			}
		});
		
		btnMC = new JButton();
		btnMC.setContentAreaFilled(false);
		btnMC.setBorderPainted(false);
		btnMC.setIcon(new ImageIcon("img/type-03.png"));
		btnMC.setForeground(Color.WHITE);
		btnMC.setBounds(710, 150, 330, 255);
		btnMC.addMouseListener(this);
		add(btnMC);
		
		btnMC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TypeMenu("Main Course", customer);
				frame.dispose();
			}
		});
		
		
		btnDESS = new JButton();
		btnDESS.setContentAreaFilled(false);
		btnDESS.setBorderPainted(false);
		btnDESS.setIcon(new ImageIcon("img/type-04.png"));
		btnDESS.setForeground(Color.WHITE);
		btnDESS.setBounds(295, 450, 330, 255);
		btnDESS.addMouseListener(this);
		add(btnDESS);
		
		btnDESS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TypeMenu("Dessert", customer);
				frame.dispose();
			}
		});
		
		btnDRINKS = new JButton();
		btnDRINKS.setContentAreaFilled(false);
		btnDRINKS.setBorderPainted(false);
		btnDRINKS.setIcon(new ImageIcon("img/type-02.png"));
		btnDRINKS.setForeground(Color.WHITE);
		btnDRINKS.setBounds(710, 450, 330, 255);
		btnDRINKS.addMouseListener(this);
		add(btnDRINKS);
		
		btnDRINKS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TypeMenu("Drinks", customer);
				frame.dispose();
			}
		});
		
	}

	private Image resizeImage(String url, int x, int y) {
		Image dimg = null;
		try {
			BufferedImage img = ImageIO.read(new File(url));
			dimg = img.getScaledInstance(x, y, Image.SCALE_SMOOTH);

		} catch (IOException ex) {
			ex.printStackTrace(System.err);
		}
		return dimg;
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

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {

		if (e.getSource().equals(btnAPP)) {
			btnAPP.setIcon(new ImageIcon(resizeImage("img/type-01.png", 350, 275)));
		}
		if (e.getSource().equals(btnMC)) {
			btnMC.setIcon(new ImageIcon(resizeImage("img/type-03.png", 350, 275)));
		}
		if (e.getSource().equals(btnDESS)) {
			btnDESS.setIcon(new ImageIcon(resizeImage("img/type-04.png", 350, 275)));
		}
		if (e.getSource().equals(btnDRINKS)) {
			btnDRINKS.setIcon(new ImageIcon(resizeImage("img/type-02.png", 350, 275)));
		}
		if (e.getSource().equals(btnBack)) {
			btnBack.setIcon(new ImageIcon(resizeImage("img/back.png", 109, 46)));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {

		if (e.getSource().equals(btnAPP)) {
			btnAPP.setIcon(new ImageIcon(resizeImage("img//type-01.png", 330, 255)));
		}
		if (e.getSource().equals(btnMC)) {
			btnMC.setIcon(new ImageIcon(resizeImage("img//type-03.png", 330, 255)));
		}
		if (e.getSource().equals(btnDESS)) {
			btnDESS.setIcon(new ImageIcon(resizeImage("img//type-04.png", 330, 255)));
		}
		if (e.getSource().equals(btnDRINKS)) {
			btnDRINKS.setIcon(new ImageIcon(resizeImage("img//type-02.png", 330, 255)));
		}
		if (e.getSource().equals(btnBack)) {
			btnBack.setIcon(new ImageIcon(resizeImage("img/back.png", 99, 36)));
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
