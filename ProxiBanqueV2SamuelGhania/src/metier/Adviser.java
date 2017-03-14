package metier;


import java.util.ArrayList;
import java.util.List;

import service.ActorService;


public class Adviser extends Actor{

	private long idAdviser;
	private String pwdAdviser;
	private List<Client> listOfClient = new ArrayList<>();
	
	public static final int MAXCLIENT = 10;
	
	public Adviser(long idAviser, String idAgence, String lastName, String firstName, long cellphone) {
		super(idAgence, lastName, firstName, cellphone);
		// ActorService.addAdviserToBDD(this);
		
	}
	public Adviser(String idAgence, String lastName, long cellphone)
	{
		this(ActorService.genIdAdviser(), idAgence, lastName, "", cellphone);
	}
	

	public Adviser(String idAgence, String lastName)
	{
		
		this(ActorService.genIdAdviser(), idAgence, lastName, "", 0);
	}
	
	public Adviser () {
		super();
	}
	
	public Adviser(String adAgence, String lastName, String firstName, long cellphone, long idAdviser,
			String pwdAdviser) {
		super(adAgence, lastName, firstName, cellphone);
		this.setIdAdviser(idAdviser);
		this.setPwdAdviser(pwdAdviser);
	}
	
	public Adviser(String adAgence, String lastName, String firstName, long cellphone) {
		super(adAgence, lastName, firstName, cellphone);
	}
	public boolean addClient(Client cl)
	{
		if (this.listOfClient.size() < MAXCLIENT)
		{
			this.listOfClient.add(cl);
			return true;
		}
		else
			return false;
			
	}
	
	public boolean isAviableToNewClient()
	{
		if (this.listOfClient.size()<10)
			return true;
		else
			return false;
	}
	public List<Client> getListOfClient() {
		return listOfClient;
	}
	public long getIdAdviser() {
		return idAdviser;
	}
	public void setIdAdviser(long idAdviser) {
		this.idAdviser = idAdviser;
	}
	public String getPwdAdviser() {
		return pwdAdviser;
	}
	public void setPwdAdviser(String pwdAdviser) {
		this.pwdAdviser = pwdAdviser;
	}
	
	

}
