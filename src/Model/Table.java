package Model;

import java.util.ArrayList;

public class Table {
	private int no_meja;
	private ArrayList <Menu> myOrder;
	
	public int getNo_meja() {
		return no_meja;
	}
	public void setNo_meja(int no_meja) {
		this.no_meja = no_meja;
	}
	public ArrayList<Menu> getMyOrder() {
		return myOrder;
	}
	public void setMyOrder(ArrayList<Menu> myOrder) {
		this.myOrder = myOrder;
	}
	
	
}
