package View.customer;

import java.awt.Color;
import java.awt.Dimension;
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
import Control.CtrlMyOrder;
import Control.CtrlWaiter;
import Model.Menu;
import Model.Order;
import Model.Table;
import Model.Transaction;
import View.Home;

public class MyOrderDisplay extends JPanel {

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int screenWidth = screenSize.width;
	private int screenHeight = screenSize.height;

	private DefaultTableModel tabelModel;
	private JScrollPane js;
	private JFrame frame;
	private JLabel lblICON;
	private JButton btnBack;
	private Table customer;
	private JTable tabel;

	public MyOrderDisplay(JFrame frame, Table customer) {
		this.customer = customer;
		this.frame = frame;
		initMyOrderDisplay();
	}

	private void initMyOrderDisplay() {

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
		add(btnBack);

		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Home(customer);
				frame.dispose();
			}
		});
		
		String[] col = { "ID", "Food Names", "Price" };
		if (customer.getMyOrder() != null) {
			tabelModel = new DefaultTableModel(col, 0);
			for (Menu menu : customer.getMyOrder()) {
				Object[] data = { menu.getMenu_id(), menu.getMenu_name(), menu.getPrice() };
				tabelModel.addRow(data);
			}
			tabel = new JTable(tabelModel);
			js = new JScrollPane(tabel);
			js.setBounds((screenWidth / 2) - 165, 270, 930, 450);
			js.setVisible(true);
			add(js);
		}
	}
}
