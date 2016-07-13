package Control;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Database.DbMySQL;
import Model.Transaction;

public class CtrlTransaction {
	List<Transaction> transaction = new ArrayList();
	
	public List<Transaction> getTransList() {
		String sql = "select * from transaction";
		try {
			if (DbMySQL.logOn() == null) {
				return null;
			} else {
				Statement stm = DbMySQL.logOn().createStatement();
				ResultSet rs = stm.executeQuery(sql);
				while (rs.next()) {
					String[] date = rs.getString("date").split("-");
					Transaction t = new Transaction (
						date[2],
						date[1],
						date[0],
						rs.getString("menu_id"),
						rs.getString("price"),
						rs.getInt("transaction_id"),
						rs.getDouble("total"),
						false
					);
					transaction.add(t);
				}
				DbMySQL.logOff();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return transaction;
	}
}
