package View.staff;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Control.CtrlCashier;
import Main.WelcomeLogin;
import Model.Staff;
import Model.Transaction;

public class VCashier extends JPanel{
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int screenWidth = screenSize.width;
	private int screenHeight = screenSize.height;
	private Staff stf;
	
	public VCashier(JFrame frame, Staff stf){
		this.stf = stf;
		this.frame = frame;
		initVCashier();
	}

	private void initVCashier() {
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
		
		btnCheckTrans = new JButton();
		btnCheckTrans.setText("Check Transaction");
		btnCheckTrans.setBounds(95, 150, 330, 255);
		btnCheckTrans.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String[] col = {
						"ID", "Date", "Table", "Menu", "Price", "Total"
				};
				
				tabelModel = new DefaultTableModel(col, 0);
				List<Transaction> listT = CtrlCashier.getTransList();
				for (Transaction transaction : listT) {
					String date = transaction.gettDay() + "-" + transaction.gettMonth() + "-" + transaction.gettYear();
					Object[] data = {
							transaction.getTransaction_id(), 
							date,
							transaction.getNo_meja(),
							transaction.getMenu_id(),
							transaction.getPrice(),
							transaction.getTotal()
					};
					tabelModel.addRow(data);
				}
				
				tabel = new JTable(tabelModel);
				
				js = new JScrollPane(tabel);
				js.setBounds(0, 0, 800, 500);
				pnlCheckTrans.add(js);
			}
		});
		
		btnBill = new JButton();
		btnBill.setText("Bill");
		btnBill.setBounds(95, 450, 330, 255);
		
		pnlCheckTrans = new JPanel();
		pnlCheckTrans.setBounds(470, 150, 800, 555);
		pnlCheckTrans.setOpaque(false);
		pnlCheckTrans.setLayout(null);
		
		add(lblIntro);
		add(btnBill);
		add(btnCheckTrans);
		add(pnlCheckTrans);
	}
	private DefaultTableModel tabelModel;
	private JPanel pnlCheckTrans;
	private JButton btnBill;
	private JButton btnCheckTrans;
	private JButton btnSignOut;
	private JLabel lblIntro;
	private JLabel lblICON;
	private JTable tabel;
	private JScrollPane js;
	private JFrame frame;
	
}
