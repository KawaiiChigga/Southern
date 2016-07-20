package View.staff;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

import Control.CtrlCashier;
import Control.CtrlWaiter;
import Main.WelcomeLogin;
import Model.Menu;
import Model.Order;
import Model.Staff;
import Model.Transaction;

public class VWaiter extends JPanel implements MouseListener{
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int screenWidth = screenSize.width;
	private int screenHeight = screenSize.height;
	private Staff stf;
	private Order order;
	private Menu menu;
	private Timer t;
	private Timer timer;
	private int count;
	public VWaiter(JFrame frame, Staff stf){
		this.stf = stf;
		this.frame = frame;
		initVWaiter();
	}
	private void initVWaiter() {
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
		btnSignOut.addMouseListener(this);
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
		lblIsCooking.setText("is serving");
		lblIsCooking.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblIsCooking.setHorizontalAlignment(JLabel.CENTER);
		lblIsCooking.setBounds((screenWidth/2)-100, 150, 200, 150);
		lblIsCooking.setVisible(false);
		
		lblMenuName = new JLabel();
		lblMenuName.setFont(new Font("Agency FB", Font.PLAIN, 50));
		lblMenuName.setHorizontalAlignment(JLabel.CENTER);
		lblMenuName.setBounds((screenWidth/2)-100, 200, 200, 150);
		lblMenuName.setVisible(false);
		
		
		btnServe = new JButton();
		btnServe.setBounds((screenWidth/2)-165, 300, 330, 255);
		btnServe.setIcon(new ImageIcon("img/serve-01.png"));
		btnServe.addMouseListener(this);
		btnServe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				order = CtrlWaiter.Serve();
			
				if (order != null) {
					menu = CtrlWaiter.getMenuInfo(order.getMenu_id());
					CtrlWaiter.FinishServe(order.getOrder_id());
					JOptionPane.showMessageDialog(null,"Please serve "+menu.getMenu_name()+" to table " +order.getTable_id()+ "!", "Information", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Readylist is Empty!", "Information", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		add(lblTimer);
		add(lblIsCooking);
		add(lblMenuName);
		add(btnServe);
	}
	private JButton btnServe;
	private JButton btnSignOut;
	private JLabel lblIntro;
	private JLabel lblICON;
	private JLabel lblTimer;
	private JLabel lblIsCooking;
	private JLabel lblMenuName;
	private JFrame frame;
	
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
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {

		if (e.getSource().equals(btnSignOut)) {
			btnSignOut.setIcon(new ImageIcon(resizeImage("img/signout.png", 109, 46)));
		}
		if (e.getSource().equals(btnServe)) {
			btnServe.setIcon(new ImageIcon(resizeImage("img/serve-01.png", 370, 295)));
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {

		if (e.getSource().equals(btnSignOut)) {
			btnSignOut.setIcon(new ImageIcon(resizeImage("img/signout.png", 99, 36)));
		}
		if (e.getSource().equals(btnServe)) {
			btnServe.setIcon(new ImageIcon(resizeImage("img/serve-01.png", 330, 255)));
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
