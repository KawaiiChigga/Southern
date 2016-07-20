package Control;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Database.DbMySQL;
import Model.Menu;
import Model.Order;

public class CtrlWaiter {
	public static List<Order> getReadyList() {
		List<Order> orderlist = new ArrayList();
		String sql = "select * from orderlist where isReady = 2";
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
	public static Order Serve() {
		String sql = "select * from orderlist where isready = 2";
		Order cooking = null;
		try {
			Statement stm = DbMySQL.logOn().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if(rs.next())
			{
				cooking = new Order(
					rs.getInt("order_id"),
					rs.getInt("menu_id"),
					rs.getString("table_id"),
					0
				);			
			}
			DbMySQL.logOff();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return cooking;
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
	public static void FinishServe(int order_id) {
		String sql = "select * from orderlist where order_id = " + order_id;
		try {
			Statement stm = DbMySQL.logOn().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if(rs.next())
			{
				String update = "DELETE FROM orderlist where order_id = "+rs.getInt("order_id");
				stm.executeUpdate(update);				
			}
			DbMySQL.logOff();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
