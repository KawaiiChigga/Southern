package cutomer;

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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class WelcomeLoginDisplay extends JPanel implements ActionListener, KeyListener {

	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int screenWidth = screenSize.width;
	private int screenHeight = screenSize.height;
	
	private JLabel lblNAME, lblPASS, lblICON;
	private JTextField txtNAME;
	private JPasswordField txtPASS;
	private JCheckBox cbPASS;
	private JButton btn;
	private JFrame frame;
	private Image bg;
	
	
	public WelcomeLoginDisplay(JFrame frame){
		this.frame = frame;
		initWelcomeLoginDisplay();
	}
	
	private void initWelcomeLoginDisplay(){
		
		setPreferredSize(new Dimension(screenWidth, screenHeight));
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
//		ImageIcon img = new ImageIcon("src/images/.jpg");
//		bg = img.getImage();
		
		lblICON = new JLabel();
		lblICON.setIcon(new ImageIcon("img/abs.png"));
		lblICON.setBounds(580, 10, 200, 200);
		
		lblNAME = new JLabel("Name");
		lblNAME.setForeground(Color.WHITE);
		lblNAME.setFont(new Font("Agency FB", Font.ITALIC, 50));
		lblNAME.setBounds(580, 300, 150, 50);
		
		txtNAME = new JTextField();
		txtNAME.setFont(new Font("Agency FB", Font.CENTER_BASELINE, 32));
		txtNAME.setBounds(580, 350, 220, 40);
		
		lblPASS = new JLabel("Password");
		lblPASS.setForeground(Color.WHITE);
		lblPASS.setFont(new Font("Agency Fb", Font.ITALIC, 50));
		lblPASS.setBounds(580, 400, 170, 50);
		
		txtPASS = new JPasswordField();
		txtPASS.setEchoChar('*');
		txtPASS.setFont(new Font("Agency FB", Font.CENTER_BASELINE, 32));
		txtPASS.setBounds(580, 450, 220, 40);
		
		cbPASS = new JCheckBox("Show Password");
		cbPASS.setContentAreaFilled(false);
		cbPASS.setForeground(Color.WHITE);
		cbPASS.setFont(new Font("Agency FB", Font.PLAIN, 32));
		cbPASS.setBounds(580, 500, 250, 25);
		
		btn = new JButton("Login");
		btn.setFont(new Font("Agency FB", Font.PLAIN, 20));
		btn.setForeground(Color.WHITE);
		btn.setBackground(Color.DARK_GRAY);
		btn.setBounds(550, 550, 300, 50);
	
		txtNAME.addKeyListener(this);
		txtPASS.addKeyListener(this);
		
		add(lblICON);
		add(lblNAME);
		add(txtNAME);
		add(lblPASS);
		add(txtPASS);
		add(cbPASS);
		add(btn);
		
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
			
			String name = txtNAME.getText();
			String pass = txtPASS.getText();
			
			if(name.equals("hizkia") && pass.equals("hizkia")){
				new Home();
				frame.dispose();
			}else{
				txtNAME.setText("");
				txtPASS.setText("");
			}
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

}
