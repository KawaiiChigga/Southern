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


public class CtrlCheckOut {
	public static String getCurrentDate() {
		Date current = new Date();
		SimpleDateFormat frmt = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = frmt.format(current);
		return dateString;
		}
	public static boolean cekExist(String tabel){
		String sql = "select * from transaction where table_id = '"+tabel+"'";
		int count=0;
		try {
			if (DbMySQL.logOn() == null) {
			
			} else {
				Statement stm = DbMySQL.logOn().createStatement();
				ResultSet rs = stm.executeQuery(sql);
				if(rs.next())
				{
					if(rs.getString("table_id")==tabel)
					{

						count++;
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(count==0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	public static void setPaymentInfo(String table) {
		String menuid="";
		String sql = "select * from orderlist where isready = 3 and table_id = '"+table+"'";
		try {
			if (DbMySQL.logOn() == null) {
				
			} else {
				Statement stm = DbMySQL.logOn().createStatement();
			
				ResultSet rs = stm.executeQuery(sql);
				if(!cekExist(table))
				{
					String insert = "INSERT INTO transaction"
						    + "(transaction_date, table_id,price,total,pay) " + "VALUES"
						    + "("+getCurrentDate()+",'"+table+"','0',0,0)";
					stm.executeUpdate(insert);
				}
				while (rs.next()) {
					menuid+=rs.getString("menu_id")+",";
				}
				
				String update = "UPDATE transaction SET menu_id="+menuid+" where table_id = "+table;
				stm.executeUpdate(update);	
				DbMySQL.logOff();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
