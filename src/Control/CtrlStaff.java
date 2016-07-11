package Control;

import java.util.List;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Staff;
import Database.DbMySQL;

public class CtrlStaff {
	public List<Staff> getStaffInfo() {
		List<Staff> staffInfo = new ArrayList();
		String sql = "select * from staff";
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
					Staff stf = new Staff(
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
					staffInfo.add(stf);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return staffInfo;
	}
	
}
