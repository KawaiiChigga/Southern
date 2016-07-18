package View.staff;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import Control.CtrlChef;
import Main.WelcomeLogin;
import Model.Menu;
import Model.Order;
import Model.Staff;

public class VChef extends JPanel{
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int screenWidth = screenSize.width;
	private int screenHeight = screenSize.height;
	private Staff stf;
	private Order order;
	private Menu menu;
	private Timer t;
	private int count;
	
	public VChef(JFrame frame, Staff stf){
		this.stf = stf;
		this.frame = frame;
		initVChef();
	}

	private void initVChef() {
		// TODO Auto-generated method stub
		setPreferredSize(new Dimension(screenWidth, screenHeight));
		setBackground(Color.WHITE);
		setLayout(null);
		
		lblICON = new JLabel();
		lblICON.setIcon(new ImageIcon("img/logo_chocolate2.png"));
		lblICON.setBounds(20, 10, 200, 120);
		add(lblICON);
		
		btnSignOut = new JButton();
		btnSignOut.setContentAreaFilled(false);
		btnSignOut.setBorderPainted(false);
		btnSignOut.setIcon(new ImageIcon("img/signout.png"));
		btnSignOut.setForeground(Color.WHITE);
		btnSignOut.setBounds(1146, 50, 109, 46);
		add(btnSignOut);
		
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new WelcomeLogin();
				frame.dispose();
			}
		});
		
		lblIntro = new JLabel("Hello, " + stf.getName() + "!");
		lblIntro.setBounds(300, 50, 300, 100);
		lblIntro.setFont(new Font("Agency FB", Font.PLAIN, 50));
		add(lblIntro);
		
		lblTimer = new JLabel();
		lblTimer.setVisible(false);
		
		lblIsCooking = new JLabel();
		lblIsCooking.setText("is cooking");
		lblIsCooking.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblIsCooking.setHorizontalAlignment(JLabel.CENTER);
		lblIsCooking.setBounds((screenWidth/2)-100, 150, 200, 150);
		lblIsCooking.setVisible(false);
		
		lblMenuName = new JLabel();
		lblMenuName.setFont(new Font("Agency FB", Font.PLAIN, 50));
		lblMenuName.setHorizontalAlignment(JLabel.CENTER);
		lblMenuName.setBounds((screenWidth/2)-100, 200, 200, 150);
		lblMenuName.setVisible(false);
		
		btnCook = new JButton();
		btnCook.setText("Cook");
		btnCook.setBounds((screenWidth/2)-165, 300, 330, 255);
		btnCook.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				order = CtrlChef.Cook();
				if (order != null) {
					menu = CtrlChef.getMenuInfo(order.getMenu_id());
					count = 0;
					btnCook.setVisible(false);
					btnSignOut.setVisible(false);
					t = new Timer(1000, null);
					lblTimer.setText(menu.getDuration() + "");
					lblTimer.setHorizontalAlignment(JLabel.CENTER);
					lblTimer.setFont(new Font("Agency FB", Font.BOLD, 140));
					lblTimer.setBounds((screenWidth/2)-50, 400, 100, 150);
					lblTimer.setVisible(true);
					lblMenuName.setText(menu.getMenu_name());
					lblMenuName.setVisible(true);
					lblIsCooking.setVisible(true);
					t.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							if (count < menu.getDuration()) {
								count++;
								lblTimer.setText((menu.getDuration()-count) + "");
								add(lblTimer);
							} else {
								count = 0;
								btnCook.setVisible(true);
								btnSignOut.setVisible(true);
								lblTimer.setVisible(false);
								lblMenuName.setVisible(false);
								lblIsCooking.setVisible(false);
								CtrlChef.FinishCook(order.getOrder_id());
								t.stop();
							}
						}
					});
					t.start();
				} else {
					JOptionPane.showMessageDialog(null, "Orderlist is Empty!", "Information", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		add(lblTimer);
		add(lblIsCooking);
		add(lblMenuName);
		add(btnCook);
	}
	private JButton btnCook;
	private JButton btnSignOut;
	private JLabel lblIntro;
	private JLabel lblICON;
	private JLabel lblTimer;
	private JLabel lblIsCooking;
	private JLabel lblMenuName;
	private JFrame frame;
}
