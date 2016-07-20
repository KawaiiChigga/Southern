package View.customer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Control.CtrlMyOrder;
import Main.WelcomeLogin;
import Model.Table;
import View.Home;

public class FoodProcessDisplay extends JPanel{
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int screenWidth = screenSize.width;
	private int screenHeight = screenSize.height;

	private JFrame frame;
	private JLabel lblICON;
	private JButton btnBack;
	private DefaultTableModel tabelModel;
	private JTable tabel;
	private JScrollPane js;
	private Table customer;
	private JLabel lblNull;
	public FoodProcessDisplay(JFrame frame, Table customer){
		this.frame = frame;
		this.customer = customer;
		initFoodProcessDisplay();
	}
	
	private void initFoodProcessDisplay() {
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
		
		if (customer.getMyOrder() != null) {
			String[] col = {
				"Food Name", "Queue Number"	
			};
			tabelModel = new DefaultTableModel(col, 0);
			String[] queueName = CtrlMyOrder.getQueueName(customer.getNo_meja()).split(",");
			String[] queue = CtrlMyOrder.getQueueInfo(customer.getNo_meja()).split(",");
			if (queueName.length == 0) {
				lblNull = new JLabel();
				lblNull.setText("Your food queue is empty :(");
				lblNull.setFont(new Font("Agency FB", Font.BOLD, 50));
				lblNull.setBounds((screenWidth/2)-300, 300, 600, 150);
				lblNull.setHorizontalAlignment(JLabel.CENTER);
				add(lblNull);
			} else {
				for(int i = 0; i < queueName.length; i++) {
					Object[] data = {
							queueName[i],
							queue[i]
					};
					tabelModel.addRow(data);
				}
				
				tabel = new JTable(tabelModel);
				
				js = new JScrollPane(tabel);
				js.setBounds((screenWidth / 2) - 200, 150, 400, 450);
				
				add(js);
			}
		} else {
			lblNull = new JLabel();
			lblNull.setText("Your food queue is empty :(");
			lblNull.setFont(new Font("Agency FB", Font.BOLD, 50));
			lblNull.setBounds((screenWidth/2)-300, 300, 600, 150);
			lblNull.setHorizontalAlignment(JLabel.CENTER);
			add(lblNull);
		}
	}
}
