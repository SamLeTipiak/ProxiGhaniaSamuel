package metier;


public class Actor {
	
	private String idAgence;
	private String lastName;
	private String firstName;
	private long cellphone;

	public Actor(String adAgence, String lastName, String firstName, long cellphone) {
		
		this.idAgence = adAgence;
		this.lastName = lastName;
		this.firstName = firstName;
	}

	
	public Actor(String idAgence, String lastName,String firstname) {
		
	}

	public Actor() {
		
	}

	public String getIdAgence() {
		return idAgence;
	}

	public void setIdAgence(String idAgence) {
		this.idAgence = idAgence;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public long getCellphone() {
		return cellphone;
	}

	public void setCellphone(long cellphone) {
		this.cellphone = cellphone;
	}

}
