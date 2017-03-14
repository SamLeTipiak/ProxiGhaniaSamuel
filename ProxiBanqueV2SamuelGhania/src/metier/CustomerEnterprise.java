package metier;

import service.ActorService;

public class CustomerEnterprise extends Client{
	

	public CustomerEnterprise(long id, String idAgence, String lastName, String firstName, long cellphone, String adress, String zipCode, String town) {
		super(id, idAgence, lastName, firstName, cellphone,  adress,  zipCode,  town);
		super.type = Client.etype.ENTERPRISE;
		super.overdraftRate = -1000.0;
		
	}
	public CustomerEnterprise(String idAgence, String lastName) {
		this(ActorService.genIdClient(), idAgence, lastName, "", 0, "", "", "");
	}

}
