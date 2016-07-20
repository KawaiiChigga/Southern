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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Control.CtrlCheckout;
import Main.WelcomeLogin;
import Model.Table;

public class HomeDisplay extends JPanel implements ActionListener, MouseListener {

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int screenWidth = screenSize.width;
	private int screenHeight = screenSize.height;
	private JFrame frame;
	private Image bg;
	private JLabel lblICON;
	private Table customer;
	private JButton btnMENU, btnMYORDER, btnFP, btnCHECKOUT, btnBack;

	public HomeDisplay(JFrame frame, Table customer) {
		this.customer = customer;
		this.frame = frame;
		initHomeDisplay();
	}

	private void initHomeDisplay() {

		setPreferredSize(new Dimension(screenWidth, screenHeight));
		setBackground(Color.WHITE);
		setLayout(null);

		lblICON = new JLabel();
		lblICON.setIcon(new ImageIcon("img/logo_chocolate2.png"));
		lblICON.setBounds(20, 10, 200, 120);
		add(lblICON);

		btnMENU = new JButton();
		btnMENU.setContentAreaFilled(false);
		btnMENU.setBorderPainted(false);
		btnMENU.setIcon(new ImageIcon("img/button-01.png"));
		btnMENU.setForeground(Color.WHITE);
		btnMENU.setBounds(295, 150, 330, 255);
		btnMENU.addMouseListener(this);
		add(btnMENU);

		btnMENU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Menus(customer);
				frame.dispose();
			}
		});

		btnMYORDER = new JButton();
		btnMYORDER.setContentAreaFilled(false);
		btnMYORDER.setBorderPainted(false);
		btnMYORDER.setIcon(new ImageIcon("img/button-06.png"));
		btnMYORDER.setForeground(Color.WHITE);
		btnMYORDER.setBounds(710, 150, 330, 255);
		btnMYORDER.addMouseListener(this);
		add(btnMYORDER);

		btnMYORDER.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MyOrder(customer);
				frame.dispose();
			}
		});

		btnFP = new JButton();
		btnFP.setContentAreaFilled(false);
		btnFP.setBorderPainted(false);
		btnFP.setIcon(new ImageIcon("img/button2-01.png"));
		btnFP.setForeground(Color.WHITE);
		btnFP.setBounds(710, 450, 330, 255);
		btnFP.addMouseListener(this);
		add(btnFP);

		btnFP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FoodProcess(customer);
				frame.dispose();
			}
		});

		btnCHECKOUT = new JButton();
		btnCHECKOUT.setContentAreaFilled(false);
		btnCHECKOUT.setBorderPainted(false);
		btnCHECKOUT.setIcon(new ImageIcon("img/button-04.png"));
		btnCHECKOUT.setForeground(Color.WHITE);
		btnCHECKOUT.setBounds(295, 450, 330, 255);
		btnCHECKOUT.addMouseListener(this);
		add(btnCHECKOUT);

		btnCHECKOUT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int s = JOptionPane.showConfirmDialog(null, "Are you sure want to checkout?", "", JOptionPane.YES_NO_OPTION);
				if (s == JOptionPane.YES_OPTION) {
					boolean success = CtrlCheckout.setPaymentInfo(customer.getNo_meja());
					if (success) {
						JOptionPane.showMessageDialog(null, "Thank You!", "Information", JOptionPane.INFORMATION_MESSAGE);
						new WelcomeLogin();
						frame.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Your payment is empty", "Information", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});

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
				if (customer.getMyOrder() == null) {
					new WelcomeLogin();
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Please complete your bill first.");
				}

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

		if (e.getSource().equals(btnMENU)) {
			btnMENU.setIcon(new ImageIcon(resizeImage("img/button-01.png", 350, 275)));
		}
		if (e.getSource().equals(btnMYORDER)) {
			btnMYORDER.setIcon(new ImageIcon(resizeImage("img/button-06.png", 350, 275)));
		}
		if (e.getSource().equals(btnFP)) {
			btnFP.setIcon(new ImageIcon(resizeImage("img/button2-01.png", 350, 275)));
		}
		if (e.getSource().equals(btnCHECKOUT)) {
			btnCHECKOUT.setIcon(new ImageIcon(resizeImage("img/button-04.png", 350, 275)));
		}
		if (e.getSource().equals(btnBack)) {
			btnBack.setIcon(new ImageIcon(resizeImage("img/back.png", 109, 46)));
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {

		if (e.getSource().equals(btnMENU)) {
			btnMENU.setIcon(new ImageIcon(resizeImage("img/button-01.png", 330, 255)));
		}
		if (e.getSource().equals(btnMYORDER)) {
			btnMYORDER.setIcon(new ImageIcon(resizeImage("img/button-06.png", 330, 255)));
		}
		if (e.getSource().equals(btnFP)) {
			btnFP.setIcon(new ImageIcon(resizeImage("img/button2-01.png", 330, 255)));
		}
		if (e.getSource().equals(btnCHECKOUT)) {
			btnCHECKOUT.setIcon(new ImageIcon(resizeImage("img/button-04.png", 330, 255)));
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

		
	}

}
