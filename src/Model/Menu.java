package Model;

public class Menu {
	private String menu_name, category, type, explanation, url ;
	private int menu_id, duration;
	private boolean isAvailable;
	private double price;
	
	public Menu(String menu_name, String category, String type, String explanation, String url, int menu_id, int duration,
			boolean isAvailable, double price) {
		super();
		this.menu_name = menu_name;
		this.category = category;
		this.type = type;
		this.explanation = explanation;
		this.url = url;
		this.menu_id = menu_id;
		this.duration = duration;
		this.isAvailable = isAvailable;
		this.price = price;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
