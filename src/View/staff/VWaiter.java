package View.staff;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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

public class VWaiter extends JPanel{
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
		refresh();
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
		
		btnRefresh = new JButton();
		btnRefresh.setBounds((screenWidth/2)+(screenWidth/10), 600, 100, 100);
		btnRefresh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				refresh();
			}
		});
		
		btnServe = new JButton();
		btnServe.setBounds((screenWidth/2)-(screenWidth/3), 300, 330, 255);
		btnServe.setIcon(new ImageIcon("img/cook-01.png"));
		btnServe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				order = CtrlWaiter.Serve();
				refresh();
				if (order != null) {
					menu = CtrlWaiter.getMenuInfo(order.getMenu_id());
					CtrlWaiter.FinishServe(order.getOrder_id());
					refresh();
					JOptionPane.showMessageDialog(null, menu.getMenu_name()+" Served!", "Information", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Readylist is Empty!", "Information", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		add(lblTimer);
		add(lblIsCooking);
		add(lblMenuName);
		add(btnServe);
		add(btnRefresh);
	}
	public void refresh() {
		String[] col = {
				"ID", "Table","Menu"
		};
		tabelModel = null;
		tabelModel = new DefaultTableModel(col, 0);
		List<Order> listT = CtrlWaiter.getReadyList();
		for (Order readylist : listT) {
			Object[] data = {
					readylist.getMenu_id(),
					readylist.getTable_id(),
					CtrlWaiter.getMenuInfo(readylist.getMenu_id()).getMenu_name()
			};
			tabelModel.addRow(data);
		}
		
		tabel = new JTable(tabelModel);
		
		js = new JScrollPane(tabel);
		js.setBounds((screenWidth/2)+(screenWidth/10), 20, 330, 500);
		js.setVisible(true);
		add(js);
	}
	private JButton btnServe;
	private JButton btnRefresh;
	private JButton btnSignOut;
	private JLabel lblIntro;
	private JLabel lblICON;
	private JLabel lblTimer;
	private JLabel lblIsCooking;
	private JLabel lblMenuName;
	private DefaultTableModel tabelModel;
	private JTable tabel;
	private JScrollPane js;
	private JFrame frame;
}