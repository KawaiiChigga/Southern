package Control;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Database.DbMySQL;
import Model.Menu;
import Model.Transaction;

public class CtrlMenuList {
	public List<Menu> getMenuList() {
		List<Menu> menulist = new ArrayList();
		String sql = "select * from menulist";
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
						true,
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
}