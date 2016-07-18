package Control;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Database.DbMySQL;
import Model.Menu;
import Model.Order;
//anjing lah tugas teh
public class CtrlOrderList {
	public List<Order> getOrderList(String tipe) {
		List<Order> orderlist = new ArrayList();
		String sql = "select * from orderlist where isReady = 0";
		try {
			if (DbMySQL.logOn() == null) {
				return null;
			} else {
				Statement stm = DbMySQL.logOn().createStatement();
				ResultSet rs = stm.executeQuery(sql);
				while (rs.next()) {
					Order t = new Order(rs.getString("order_id"),
							rs.getString("menu_id"), 
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
	}//anjing lah tugas teh
	public void Cook() {
		//anjing lah tugas teh
		String sql = "select * from orderlist where isready = 0";
		try {
			Statement stm = DbMySQL.logOn().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if(rs.next())
			{
				String update = "UPDATE orderlist SET isready=1 where order_id = "+rs.getInt("order_id");
				stm.executeUpdate(update);				
			}
			DbMySQL.logOff();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void FinishCook() {
		String sql = "select * from orderlist where isready = 1 ";
		try {
			Statement stm = DbMySQL.logOn().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if(rs.next())
			{
				
				//anjing lah tugas teh
				String update = "UPDATE orderlist SET isready=2 where order_id = "+rs.getInt("order_id");
				stm.executeUpdate(update);				
			}
			DbMySQL.logOff();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//anjing lah tugas teh
}
