package View.customer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Control.CtrlStaff;
import Model.Staff;
import View.Home;


public class WelcomeLoginDisplay extends JPanel implements ActionListener, KeyListener {

	private Staff cs;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int screenWidth = screenSize.width;
	private int screenHeight = screenSize.height;
	
	public WelcomeLoginDisplay(JFrame frame){
		this.frame = frame;
		initWelcomeLoginDisplay();
	}
	
	private void initWelcomeLoginDisplay(){
		
		setPreferredSize(new Dimension(screenWidth, screenHeight));
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		ImageIcon img = new ImageIcon("img/bg.jpg");
		bg = img.getImage();
		
		lblSITE = new JLabel();
		lblSITE.setIcon(new ImageIcon("img/site.png"));
		lblSITE.setBounds(0, 5, 1366, 29);
		add(lblSITE);
		
		lblICON = new JLabel();
		lblICON.setIcon(new ImageIcon("img/logo_white.png"));
		lblICON.setBounds(500, 50, 400, 239);
		add(lblICON);
		
		lblNAME = new JLabel("Name");
		lblNAME.setForeground(Color.WHITE);
		lblNAME.setFont(new Font("Agency FB", Font.PLAIN, 50));
		lblNAME.setBounds(450, 350, 150, 50);
		add(lblNAME);
		
		txtNAME = new JTextField();
		txtNAME.setFont(new Font("Agency FB", Font.CENTER_BASELINE, 32));
		txtNAME.setBounds(700, 355, 220, 40);
		add(txtNAME);
		
		lblPASS = new JLabel("Password");
		lblPASS.setForeground(Color.WHITE);
		lblPASS.setFont(new Font("Agency Fb", Font.PLAIN, 50));
		lblPASS.setBounds(450, 425, 170, 50);
		add(lblPASS);
		
		txtPASS = new JPasswordField();
		txtPASS.setEchoChar('*');
		txtPASS.setFont(new Font("Agency FB", Font.CENTER_BASELINE, 32));
		txtPASS.setBounds(700, 430, 220, 40);
		add(txtPASS);
		
		cbPASS = new JCheckBox("Show Password");
		cbPASS.setContentAreaFilled(false);
		cbPASS.setForeground(Color.WHITE);
		cbPASS.setFont(new Font("Agency FB", Font.PLAIN, 16));
		cbPASS.setBounds(700, 475, 250, 25);
		add(cbPASS);
		
		btn = new JButton();
		btn.setIcon(new ImageIcon("img/go.png"));
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false);
		btn.setBounds(370, 530, 300, 139);
		add(btn);
		
		btnC = new JButton();
		btnC.setIcon(new ImageIcon("img/goC.png"));
		btnC.setContentAreaFilled(false);
		btnC.setBorderPainted(false);
		btnC.setBounds(730, 530, 300, 139);
		add(btnC);
		
		lblSITEE = new JLabel();
		lblSITEE.setIcon(new ImageIcon("img/site.png"));
		lblSITEE.setBounds(0, 710, 1366, 29);
		add(lblSITEE);
		
		txtNAME.addKeyListener(this);
		txtPASS.addKeyListener(this);
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				loginDetector();
			}
		});
		btnC.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new Home(cs);
				frame.dispose();
			}
		});
		
		cbPASS.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

				if(cbPASS.isSelected()){
					txtPASS.setEchoChar((char) 0);
				}else{
					txtPASS.setEchoChar('*');
				}
			}
		});
		
	}
	
	
	@Override
	public void keyPressed(KeyEvent x) {
	
		if(x.getKeyCode() == KeyEvent.VK_ENTER){
			loginDetector();
		}
	}
	public void loginDetector(){
		String name = txtNAME.getText();
		String pass = txtPASS.getText();
		boolean success=false;
		int i=0;
		cs = CtrlStaff.login(name, pass);
		if(cs != null){
			new Home(cs);
			frame.dispose();
		}else{
			txtNAME.setText("");
			txtPASS.setText("");
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(bg, 0, 0, this);
		
		Toolkit.getDefaultToolkit().sync();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {

		repaint();
	}
	
	private JLabel lblNAME, lblPASS, lblICON, lblSITE, lblSITEE;
	private JTextField txtNAME;
	private JPasswordField txtPASS;
	private JCheckBox cbPASS;
	private JButton btn;
	private JButton btnC;
	private JFrame frame;
	private Image bg;
}
