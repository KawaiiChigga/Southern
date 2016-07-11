package cutomer;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuDisplay extends JPanel {

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int screenWidth = screenSize.width;
	private int screenHeight = screenSize.height;
	private JFrame frame;

	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost/dbrestoran";
	private static String username = "root";
	private static String password = "";

	public MenuDisplay(JFrame frame) {

		this.frame = frame;
		initMenuDisplay();
	}

	private void initMenuDisplay() {

		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement stm = conn.createStatement();
			ResultSet hasil = stm.executeQuery("Select * From menulist");

			while (hasil.next()) {

				String nama = hasil.getString("menu_name");
				System.out.println(nama);
			}
			conn.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
