package metier;

import service.ActorService;

public class Director extends Actor {

	public Director(String idAgence, String lastName, String firstName, long cellphone) {
		super(ActorService.genIdAdviser(), idAgence, lastName, firstName, cellphone);
	}
	
	public Director(String idAgence, String lastName) {
		this(idAgence, lastName, "", 0);
	}
	
	

}
