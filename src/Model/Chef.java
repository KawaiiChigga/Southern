package Model;

public class Chef extends Staff{
	
	public Chef(String staff_id, String identity, String password, String name, String address, String status,
			String description, int bDay, int bMonth, int bYear, boolean isMale, boolean isAvailable) {
		super(staff_id, identity, password, name, address, status, description, bDay, bMonth, bYear, isMale, isAvailable);
		// TODO Auto-generated constructor stub
	}

	boolean cookDish() {
		return true;
	}
}
