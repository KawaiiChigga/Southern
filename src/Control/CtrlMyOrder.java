package Control;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Database.DbMySQL;
import Model.Menu;
import Model.Order;

public class CtrlMyOrder {
	public static List<Order> getOrderList(String table) {
		List<Order> orderlist = new ArrayList();
		String sql = "select * from orderlist where table_id = '"+ table + "'";
		try {
			if (DbMySQL.logOn() == null) {
				return null;
			} else {
				Statement stm = DbMySQL.logOn().createStatement();
				ResultSet rs = stm.executeQuery(sql);
				while (rs.next()) {
					Order t = new Order(rs.getInt("order_id"),
							rs.getInt("menu_id"), 
							rs.getString("table_id"),
							rs.getInt("isReady"));
					orderlist.add(t);
				}
				DbMySQL.logOff();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return orderlist;
	}
	public static Menu getMenuInfo(int menu_id) {
		String sql = "select * from menulist where menu_id = " + menu_id;
		Menu m = null;
		try {
			Statement stm = DbMySQL.logOn().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if(rs.next())
			{
				m = new Menu (
					rs.getString("menu_name"),
					rs.getString("category"),
					rs.getString("type"),
					rs.getString("explanation"),
					rs.getString("path"),
					rs.getInt("menu_id"),
					rs.getInt("duration"),
					rs.getInt("available"),
					rs.getDouble("price")
				);
			}
			DbMySQL.logOff();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return m;
	}
}