package metier;


public class CustomerCasual extends Client{
	


	public CustomerCasual(long id, String idAgence, long idAviser, String lastName, String firstName, String cellphone, String adress, String zipCode, String town) {
		super(id, idAgence, idAviser, lastName, firstName, cellphone,  adress,  zipCode,  town);
		super.type = Client.etype.CASUAL;
		super.overdraftRate = -1000.0;
		
	}
	
	


	
}
