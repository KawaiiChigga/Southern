package View.customer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import Control.CtrlMenuList;

public class AppetizerDisplay extends JPanel {

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int screenWidth = screenSize.width;
	private int screenHeight = screenSize.height;
	
	private JFrame frame;
	private DefaultTableModel table;
	
	public AppetizerDisplay(JFrame frame){
		this.frame = frame;
		initAppetizerDisplay();
	}
	
	private void initAppetizerDisplay(){
		setPreferredSize(new Dimension(screenWidth, screenHeight));
		setBackground(Color.WHITE);
		setLayout(null);
		
//		List <Menu> listM = CtrlMenuList.getMenuList();
		table = new DefaultTableModel(0,0);
		
		
	}
}
