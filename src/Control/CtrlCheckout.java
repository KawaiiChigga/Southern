package Control;

import java.io.ObjectInputStream.GetField;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Database.DbMySQL;
import Model.Menu;
import Model.Order;


public class CtrlCheckout {
	public static String getCurrentDate() {
		Date current = new Date();
		SimpleDateFormat frmt = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = frmt.format(current);
		return dateString;
	}
	public static boolean setPaymentInfo(String table_id) {
		boolean success = false;
		String menuid="";
		String price="";
		double total = 0;
		String sql = "SELECT * FROM orderlist INNER JOIN menulist ON orderlist.menu_id = menulist.menu_id WHERE table_id = '" + table_id + "'";
		try {
			if (DbMySQL.logOn() == null) {
				
			} else {
				Statement stm = DbMySQL.logOn().createStatement();
				ResultSet rs = stm.executeQuery(sql);
				while (rs.next()) {
					menuid += rs.getString("menu_id") + ",";
					price += ((int)rs.getDouble("price")) + ",";
					total += rs.getDouble("price");
				}
				if (!menuid.equals("")) {
					success = true;
					String date = getCurrentDate();
					String insert = "INSERT INTO transaction (transaction_date, menu_id, table_id, price, total, pay) VALUES ('" + 
							date + "', '" + menuid + "', '" + table_id + "', '" + price + "', " + total + ", 0)";
					stm.executeUpdate(insert);
					
					String delete = "Delete from orderlist where table_id = '" + table_id + "'";
					stm.execute(delete);
				}
				DbMySQL.logOff();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return success;
	}
}
