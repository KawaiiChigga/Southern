package Model;

public class Order {
	private String table_id;
	private int isReady, order_id, menu_id;
	
	public Order(int order_id, int menu_id, String table_id, int isReady) {
		super();
		this.order_id = order_id;
		this.menu_id = menu_id;
		this.table_id = table_id;
		this.isReady = isReady;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}

	public String getTable_id() {
		return table_id;
	}

	public void setTable_id(String table_id) {
		this.table_id = table_id;
	}

	public int getIsReady() {
		return isReady;
	}

	public void setIsReady(int isReady) {
		this.isReady = isReady;
	}
	
	
}
