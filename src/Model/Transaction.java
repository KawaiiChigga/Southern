package Model;

public class Transaction {
	String tDay, tMonth, tYear, menu_id, price, no_meja;
	int transaction_id;
	double total;
	boolean pay;
	
	public Transaction(String tDay, String tMonth, String tYear, String menu_id, String price, int transaction_id, 
			String no_meja, double total, boolean pay) {
		super();
		this.tDay = tDay;
		this.tMonth = tMonth;
		this.tYear = tYear;
		this.menu_id = menu_id;
		this.price = price;
		this.transaction_id = transaction_id;
		this.no_meja = no_meja;
		this.total = total;
		this.pay = pay;
	}
	
	public String getNo_meja() {
		return no_meja;
	}

	public void setNo_meja(String no_meja) {
		this.no_meja = no_meja;
	}

	public String gettDay() {
		return tDay;
	}
	public void settDay(String tDay) {
		this.tDay = tDay;
	}
	public String gettMonth() {
		return tMonth;
	}
	public void settMonth(String tMonth) {
		this.tMonth = tMonth;
	}
	public String gettYear() {
		return tYear;
	}
	public void settYear(String tYear) {
		this.tYear = tYear;
	}
	public String getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public boolean isPay() {
		return pay;
	}
	public void setPay(boolean pay) {
		this.pay = pay;
	}
	
	
}
