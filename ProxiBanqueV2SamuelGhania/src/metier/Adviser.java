package metier;

//import java.util.ArrayList;
//import java.util.List;

/**
 * @author Samuel Bouchet - Ghania Bouzemame
 * @version 2.0
 *
 *          <b>Adviser est la classe représentant les conseillers de la banque,
 *          elle étend la classe Actor et hérite donc de ses propriétés et
 *          méthodes.</b>
 *
 *
 *
 *          <div>Chaque conseiller est représenté par les propriétés spécifiques
 *          suivantes :
 *          <ul>
 *          <li>idAdviser, l'identifiant du conseiller au sein de la banque qui
 *          lui servira aussi de login pour se connecter au démarrage de
 *          l'application. Il est généré automatiquement par
 *          incrémentation.</li>
 *          <li>pwdAdviser, le mot de passe qui lui permettra l'accès aux
 *          données client.</li>
 *          </ul>
 *          <div>
 *
 *
 */

public class Adviser extends Actor {

	private long idAdviser;
	private String pwdAdviser;

	public static final int MAXCLIENT = 10;

	public Adviser(long idAviser, String idAgence, String lastName, String firstName, String pwdAdviser) {
		super(idAgence, lastName, firstName);
		this.idAdviser = idAviser;
		this.pwdAdviser = pwdAdviser;
		// ActorService.addAdviserToBDD(this);

	}

	public Adviser() {
		super();
	}

	public Adviser(String adAgence, String lastName, String firstName, long cellphone, long idAdviser,
			String pwdAdviser) {
		super(adAgence, lastName, firstName);
		this.setIdAdviser(idAdviser);
		this.setPwdAdviser(pwdAdviser);
	}

	// public Adviser(String adAgence, String lastName, String firstName, long
	// cellphone) {
	// super(adAgence, lastName, firstName, cellphone);
	// }
	// public boolean addClient(Client cl)
	// {
	// if (this.listOfClient.size() < MAXCLIENT)
	// {
	// this.listOfClient.add(cl);
	// return true;
	// }
	// else
	// return false;
	//
	// }

	// public boolean isAviableToNewClient()
	// {
	// if (this.listOfClient.size()<10)
	// return true;
	// else
	// return false;
	// }
	// public List<Client> getListOfClient() {
	// return listOfClient;
	// }
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
