package Control;

import java.util.List;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Staff;
import Database.DbMySQL;
public class CtrlStaff {
	
	public Staff login(String id, String pass) {
		String sql = "select * from staff where identity = '"+id+"' and password = '"+pass+"'";
		Staff stf=null;
		try {
			if (DbMySQL.logOn() == null) {
				return null;
			} else {
				Statement stm = DbMySQL.logOn().createStatement();
				ResultSet rs = stm.executeQuery(sql);
				while (rs.next()) {
					String[] birthday = rs.getString("birthday").split("-");
					boolean isMale;
					if (rs.getString("gender").equals("M")) {
						isMale = true;
					} else {
						isMale = false;
					}
					stf = new Staff(
						rs.getString("staff_id"),
						rs.getString("identity"),
						rs.getString("password"),
						rs.getString("name"),
						rs.getString("address"),
						rs.getString("status"),
						rs.getString("description"),
						Integer.parseInt(birthday[2]),
						Integer.parseInt(birthday[1]),
						Integer.parseInt(birthday[0]),
						isMale,
						true
					);
				}
				DbMySQL.logOff();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return stf;
	}
}
