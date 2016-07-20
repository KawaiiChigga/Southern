package Control;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Database.DbMySQL;
import Model.Menu;
import Model.Transaction;

public class CtrlMenuList {
	
	public static List<Menu> getMenuList(String tipe) {
		List<Menu> menulist = new ArrayList();
		String sql = "select * from menulist where type = '"+tipe+"'";
		try {
			if (DbMySQL.logOn() == null) {
				return null;
			} else {
				Statement stm = DbMySQL.logOn().createStatement();
				ResultSet rs = stm.executeQuery(sql);
				while (rs.next()) {
					Menu t = new Menu (
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
					menulist.add(t);
				}
				DbMySQL.logOff();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return menulist;
	}
	
	public static Menu getMenu(int menuID) {
		
		String sql = "select * from menulist where menu_id = "+menuID;
		Menu t = null;
		
		try {
			if (DbMySQL.logOn() == null) {
				return null;
			} else {
				Statement stm = DbMySQL.logOn().createStatement();
				ResultSet rs = stm.executeQuery(sql);
				if (rs.next()) {
					t = new Menu (
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
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return t;
	}
}