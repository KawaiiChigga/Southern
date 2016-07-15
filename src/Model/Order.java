package Model;

public class Order {
	private String order_id, menu_id, table_id;
	private int isReady;
	
	public Order(String order_id, String menu_id, String table_id, int isReady) {
		super();
		this.order_id = order_id;
		this.menu_id = menu_id;
		this.table_id = table_id;
		this.isReady = isReady;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(String menu_id) {
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
