package Model;

public class Staff {
	protected String staff_id, identity, password, name, address, status, description;
	protected int bDay, bMonth, bYear;
	protected boolean isMale, isAvailable;
	
	
	
	public Staff(String staff_id, String identity, String password, String name, String address, String status,
			String description, int bDay, int bMonth, int bYear, boolean isMale, boolean isAvailable) {
		this.staff_id = staff_id;
		this.identity = identity;
		this.password = password;
		this.name = name;
		this.address = address;
		this.status = status;
		this.description = description;
		this.bDay = bDay;
		this.bMonth = bMonth;
		this.bYear = bYear;
		this.isMale = isMale;
		this.isAvailable = isAvailable;
	}
	
	public String getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getbDay() {
		return bDay;
	}
	public void setbDay(int bDay) {
		this.bDay = bDay;
	}
	public int getbMonth() {
		return bMonth;
	}
	public void setbMonth(int bMonth) {
		this.bMonth = bMonth;
	}
	public int getbYear() {
		return bYear;
	}
	public void setbYear(int bYear) {
		this.bYear = bYear;
	}
	public boolean isMale() {
		return isMale;
	}
	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	public boolean LogOut() {
		return true;
	}
}
