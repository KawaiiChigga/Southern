package Control;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Database.DbMySQL;
import Model.Transaction;

public class CtrlCashier {
	public static List<Transaction> getTransList() {
		List<Transaction> transaction = new ArrayList();
		String sql = "select * from transaction";
		try {
			if (DbMySQL.logOn() == null) {
				return null;
			} else {
				Statement stm = DbMySQL.logOn().createStatement();
				ResultSet rs = stm.executeQuery(sql);
				while (rs.next()) {
					String[] date = rs.getString("transaction_date").split("-");
					Transaction t = new Transaction (
						date[2],
						date[1],
						date[0],
						rs.getString("menu_id"),
						rs.getString("price"),
						rs.getInt("transaction_id"),
						rs.getString("table_id"),
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
	public static Transaction getBill(String table){
		String sql = "select * from transaction where table_id = '"+table+"' and pay = 0";
		double totalprice=0;
		Transaction bill=null;
		try {
			if (DbMySQL.logOn() == null) {
				return null;
			} else {
				Statement stm = DbMySQL.logOn().createStatement();
				ResultSet rs = stm.executeQuery(sql);
				if(rs.next())
				{
					totalprice= rs.getDouble("total");
					String[] date = rs.getString("transaction_date").split("-");
					Transaction t = new Transaction (
						date[2],
						date[1],
						date[0],
						rs.getString("menu_id"),
						rs.getString("price"),
						rs.getInt("transaction_id"),
						rs.getString("table_id"),
						rs.getDouble("total"),
						false
					);
					bill=t;
				}
										
				DbMySQL.logOff();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return bill;
	}
	public static String getMenuName(int menu_id) {
		String s = null;
		String sql = "select * from menulist where menu_id = " + menu_id;
		try {
			if (DbMySQL.logOn() == null) {
				return null;
			} else {
				Statement stm = DbMySQL.logOn().createStatement();
				ResultSet rs = stm.executeQuery(sql);
				if(rs.next())
				{
					s = rs.getString("menu_name");
				}
				DbMySQL.logOff();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return s;
	}
	public static double getMenuPrice(int menu_id) {
		double s = 0;
		String sql = "select * from menulist where menu_id = " + menu_id;
		try {
			if (DbMySQL.logOn() == null) {
				return 0;
			} else {
				Statement stm = DbMySQL.logOn().createStatement();
				ResultSet rs = stm.executeQuery(sql);
				if(rs.next())
				{
					s = rs.getDouble("price");
				}
				DbMySQL.logOff();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return s;
	}
	public static void pay(int trans_id) {
		String update = "UPDATE transaction SET pay=1 where transaction_id = "+trans_id;
		try {
			Statement stm = DbMySQL.logOn().createStatement();
			stm.executeUpdate(update);
			DbMySQL.logOff();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
