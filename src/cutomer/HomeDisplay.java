package cutomer;

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
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
//		ImageIcon img = new ImageIcon("src/images/.png");
//		bg = img.getImage();
		
		lblICON = new JLabel();
		lblICON.setIcon(new ImageIcon("img/abs.png"));
		lblICON.setBounds(580, 10, 200, 200);
		add(lblICON);
		
		JButton btnMENU = new JButton("MENU");
		btnMENU.setContentAreaFilled(false);
		btnMENU.setBorderPainted(false);
//		btnMENU.setIcon(new ImageIcon("src/Images/.png"));
		btnMENU.setForeground(Color.WHITE);
		btnMENU.setBounds(500, 200, 300, 100);
		add(btnMENU);
		
		btnMENU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				new Menu());
				frame.dispose();
			}
		});
		
		JButton btnMYORDER = new JButton("MY ORDER");
		btnMYORDER.setContentAreaFilled(false);
		btnMYORDER.setBorderPainted(false);
//		btnMYORDER.setIcon(new ImageIcon("src/Images/.png"));
		btnMYORDER.setForeground(Color.WHITE);
		btnMYORDER.setBounds(650, 200, 300, 100);
		add(btnMYORDER);
		
		btnMYORDER.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				new Menu());
				frame.dispose();
			}
		});
		
		JButton btnMYACC = new JButton("MY ACCOUNT");
		btnMYACC.setContentAreaFilled(false);
		btnMYACC.setBorderPainted(false);
//		btnMYACC.setIcon(new ImageIcon("src/Images/.png"));
		btnMYACC.setForeground(Color.WHITE);
		btnMYACC.setBounds(500, 250, 300, 100);
		add(btnMYACC);
		
		btnMYACC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				new Menu());
				frame.dispose();
			}
		});
		
		JButton btnFP = new JButton("FOOD PROGRESS");
		btnFP.setContentAreaFilled(false);
		btnFP.setBorderPainted(false);
//		btnFP.setIcon(new ImageIcon("src/Images/.png"));
		btnFP.setForeground(Color.WHITE);
		btnFP.setBounds(650, 250, 300, 100);
		add(btnFP);
		
		btnFP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				new Menu());
				frame.dispose();
			}
		});
		
		JButton btnGAMES = new JButton("GAMES");
		btnGAMES.setContentAreaFilled(false);
		btnGAMES.setBorderPainted(false);
//		btnGAMES.setIcon(new ImageIcon("src/Images/.png"));
		btnGAMES.setForeground(Color.WHITE);
		btnGAMES.setBounds(500, 300, 300, 100);
		add(btnGAMES);
		
		btnGAMES.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				new Menu());
				frame.dispose();
			}
		});
		
		JButton btnCALL = new JButton("CALL WAITER");
		btnCALL.setContentAreaFilled(false);
		btnCALL.setBorderPainted(false);
//		btnCALL.setIcon(new ImageIcon("src/Images/.png"));
		btnCALL.setForeground(Color.WHITE);
		btnCALL.setBounds(650, 300, 300, 100);
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
