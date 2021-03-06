package View.staff;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

import Control.CtrlCashier;
import Main.WelcomeLogin;
import Model.Staff;
import Model.Transaction;

public class VCashier extends JPanel implements ActionListener, MouseListener{
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int screenWidth = screenSize.width;
	private int screenHeight = screenSize.height;
	private Staff stf;
	private	Timer t;
	private String tbl_num;
	public VCashier(JFrame frame, Staff stf){
		this.stf = stf;
		this.frame = frame;
		initVCashier();
		t = new Timer(15,this);
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
		
		btnCheckTrans = new JButton();
		btnCheckTrans.setBounds(95, 150, 330, 255);
		btnCheckTrans.setIcon(new ImageIcon("img/chk_trans-01.png"));
		btnCheckTrans.addMouseListener(this);
		btnCheckTrans.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				t.start();
				pnlCheckBill.setVisible(false);
				pnlCheckTrans.setVisible(true);
				
			}
		});
		
		btnBill = new JButton();
		btnBill.setBounds(95, 450, 330, 255);
		btnBill.setIcon(new ImageIcon("img/bill-01.png"));
		btnBill.addMouseListener(this);
		btnBill.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				pnlCheckTrans.setVisible(false);
				pnlCheckBill.setVisible(true);
			}
		});
		
		pnlCheckTrans = new JPanel();
		pnlCheckTrans.setBounds(470, 150, 800, 555);
		pnlCheckTrans.setOpaque(false);
		pnlCheckTrans.setLayout(null);
		pnlCheckTrans.setVisible(false);
		
		pnlCheckBill = new JPanel();
		pnlCheckBill.setBounds(470, 150, 800, 555);
		pnlCheckBill.setOpaque(false);
		pnlCheckBill.setLayout(null);
		pnlCheckBill.setVisible(false);
		
		btnRefresh = new JButton();
		btnRefresh.setBounds(325, 505, 150, 40);
		btnRefresh.setIcon(new ImageIcon("img/refresh-01.png"));
		btnRefresh.addMouseListener(this);
		btnRefresh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh();
			}	
		});
		pnlCheckTrans.add(btnRefresh);
		
		lblInsertTable = new JLabel();
		lblInsertTable.setText("Insert the table number : ");
		lblInsertTable.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblInsertTable.setBounds(0, 0, 250, 30);
		pnlCheckBill.add(lblInsertTable);
		
		txtInsertTable = new JTextField(5);
		txtInsertTable.setBounds(250, 0, 100, 35);
		txtInsertTable.setFont(new Font("Agency FB", Font.PLAIN, 30));
		pnlCheckBill.add(txtInsertTable);
		
		btnCheckBill = new JButton(new ImageIcon("img/process-01.png"));
		btnCheckBill.setBounds(370, 0, 83, 36);
		btnCheckBill.addMouseListener(this);
		btnCheckBill.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				checkBill(CtrlCashier.getBill(txtInsertTable.getText()));
			}
		});
		pnlCheckBill.add(btnCheckBill);
		
		lblTotal = new JLabel();
		lblTotal.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblTotal.setBounds(525, 300, 200, 100);
		pnlCheckBill.add(lblTotal);
		
		btnPay = new JButton();
		btnPay.setIcon(new ImageIcon("img/pay-01.png"));
		btnPay.setContentAreaFilled(false);
		btnPay.setBorderPainted(false);
		btnPay.setBounds(525, 400, 275, 150);
		btnPay.addMouseListener(this);
		btnPay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(null, "Pay this bill?", "Table Number : " + tbl_num.toUpperCase(), JOptionPane.YES_NO_OPTION);
				if (n == JOptionPane.YES_OPTION) {
					CtrlCashier.pay(CtrlCashier.getBill(tbl_num).getTransaction_id());
					txtInsertTable.setText("");
					js.setVisible(false);
					lblTotal.setText("");
					btnPay.setVisible(false);
					JOptionPane.showMessageDialog(null, "Thank you", "Payment Complete!", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnPay.setVisible(false);
		pnlCheckBill.add(btnPay);
		
		add(lblIntro);
		add(btnBill);
		add(btnCheckTrans);
		add(pnlCheckBill);
		add(pnlCheckTrans);
	}
	public void refresh() {
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
	public void checkBill(Transaction t) {
		if (t != null) {
			tbl_num = txtInsertTable.getText();
			String[] col = {
					"Name", "Price"
			};
			double total = 0;
			tabelModel = new DefaultTableModel(col, 0);
			String[] temp = t.getMenu_id().split(",");
			for (int i = 0; i < temp.length; i++) {
				int tempInt = Integer.parseInt(temp[i]);
				Object[] data = {
						CtrlCashier.getMenuName(tempInt),
						CtrlCashier.getMenuPrice(tempInt)
				};
				total += CtrlCashier.getMenuPrice(tempInt);
				tabelModel.addRow(data);
			}
			
			tabel = new JTable(tabelModel);
			
			js = new JScrollPane(tabel);
			js.setBounds(100, 50, 400, 500);
			pnlCheckBill.add(js);
			
			lblTotal.setText("Total : " + total);
			
			btnPay.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null, "Table not found!", "Information", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		refresh();
		t.stop();
	}
	
	private DefaultTableModel tabelModel;
	private JPanel pnlCheckTrans;
	private JPanel pnlCheckBill;
	private JButton btnBill;
	private JButton btnCheckTrans;
	private JButton btnSignOut;
	private JButton btnRefresh;
	private JButton btnCheckBill;
	private JButton btnPay;
	private JLabel lblInsertTable;
	private JLabel lblIntro;
	private JLabel lblICON;
	private JLabel lblTotal;
	private JTextField txtInsertTable;
	private JTable tabel;
	private JScrollPane js;
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
		if (e.getSource().equals(btnCheckTrans)) {
			btnCheckTrans.setIcon(new ImageIcon(resizeImage("img/chk_trans-01.png", 370, 295)));
		}
		if (e.getSource().equals(btnBill)) {
			btnBill.setIcon(new ImageIcon(resizeImage("img/bill-01.png", 370, 295)));
		}
		if (e.getSource().equals(btnRefresh)) {
			btnRefresh.setIcon(new ImageIcon(resizeImage("img/refresh-01.png", 160, 50)));
		}
		if (e.getSource().equals(btnCheckBill)) {
			btnCheckBill.setIcon(new ImageIcon(resizeImage("img/process-01.png", 93, 46)));
		}
		if (e.getSource().equals(btnPay)) {
			btnPay.setIcon(new ImageIcon(resizeImage("img//pay-01.png", 285, 160)));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {

		if (e.getSource().equals(btnSignOut)) {
			btnSignOut.setIcon(new ImageIcon(resizeImage("img/signout.png", 99, 36)));
		}
		if (e.getSource().equals(btnCheckTrans)) {
			btnCheckTrans.setIcon(new ImageIcon(resizeImage("img/chk_trans-01.png", 330, 255)));
		}
		if (e.getSource().equals(btnBill)) {
			btnBill.setIcon(new ImageIcon(resizeImage("img/bill-01.png", 330, 255)));
		}
		if (e.getSource().equals(btnRefresh)) {
			btnRefresh.setIcon(new ImageIcon(resizeImage("img/refresh-01.png", 150, 40)));
		}
		if (e.getSource().equals(btnCheckBill)) {
			btnCheckBill.setIcon(new ImageIcon(resizeImage("img/process-01.png", 83, 36)));
		}
		if (e.getSource().equals(btnPay)) {
			btnPay.setIcon(new ImageIcon(resizeImage("img//pay-01.png", 275, 150)));
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
