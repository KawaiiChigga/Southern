package Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbMySQL {
	public static Connection connection = null;
	
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost/dbrestoran";
	private static String username = "root";
	private static String password = "";
	
	public static Connection logOn() {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
			connection = null;
			// TODO: handle exception
		}
		return connection;
	}
	public static void logOff() {
		try {
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	public static void connect() {
		try {
			connection = logOn();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	public static void disconnect() {
		try {
			logOff();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
}
