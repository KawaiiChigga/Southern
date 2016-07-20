package Model;

import java.util.ArrayList;

public class Table {
	private String no_meja;
	private ArrayList <Menu> myOrder;
	
	public String getNo_meja() {
		return no_meja;
	}
	public void setNo_meja(String no_meja) {
		this.no_meja = no_meja;
	}
	public ArrayList<Menu> getMyOrder() {
		return myOrder;
	}
	public void setOrder(ArrayList<Menu> myOrder) {
		this.myOrder = myOrder;
	}
	public void setMyOrder(Menu myOrder) {
		this.myOrder.add(myOrder);
	}
	
}
