package View.customer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Control.CtrlMyOrder;
import Model.Menu;
import Model.Table;
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
	private JButton btnConfirm;
	private JLabel lblNull;
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
		
		btnConfirm = new JButton();
		btnConfirm.setContentAreaFilled(false);
		btnConfirm.setBorderPainted(false);
		btnConfirm.setIcon(new ImageIcon("img/confirm-01.png"));
		btnConfirm.setForeground(Color.WHITE);
		btnConfirm.setBounds((screenWidth / 2) - 55, 600, 109, 46);
		add(btnConfirm);
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure?", "Information", JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
					CtrlMyOrder.insertOrderList(customer.getMyOrder(),customer.getNo_meja());
					customer.setOrder(new ArrayList());
					new Home(customer);
					frame.dispose();
				}
			}
		});
		if (customer.getMyOrder() != null) {
			String[] col = { "ID", "Food Names", "Price" };
			
			tabelModel = new DefaultTableModel(col, 0);
			for (Menu menu : customer.getMyOrder()) {
				Object[] data = { menu.getMenu_id(), menu.getMenu_name(), menu.getPrice() };
				tabelModel.addRow(data);
			}
			if (tabelModel.getColumnCount() == 0) {
				lblNull = new JLabel();
				lblNull.setText("Your orderlist is empty :(");
				lblNull.setFont(new Font("Agency FB", Font.BOLD, 50));
				lblNull.setBounds((screenWidth/2)-300, 300, 600, 150);
				lblNull.setHorizontalAlignment(JLabel.CENTER);
				btnConfirm.setVisible(false);
				add(lblNull);
			} else {
				tabel = new JTable(tabelModel);
				js = new JScrollPane(tabel);
				js.setBounds((screenWidth / 2) - 300, 150, 600, 450);
				js.setVisible(true);
				btnConfirm.setVisible(true);
				add(js);
			}
		} else {
			lblNull = new JLabel();
			lblNull.setText("Your orderlist is empty :(");
			lblNull.setFont(new Font("Agency FB", Font.BOLD, 50));
			lblNull.setBounds((screenWidth/2)-300, 300, 600, 150);
			lblNull.setHorizontalAlignment(JLabel.CENTER);
			btnConfirm.setVisible(false);
			add(lblNull);
		}
		
	}
}
