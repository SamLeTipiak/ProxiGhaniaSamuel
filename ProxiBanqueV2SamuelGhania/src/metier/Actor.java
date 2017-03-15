package metier;


/**
 * @author Samuel Bouchet - Ghania Bouzemame
 * @version 2.0
 * 
 * <b>Actor est la classe repr�sentant tous les acteurs au sein de la banque.</b>
 * 
 * <div>Chaque acteur est repr�sent� par les propri�t�s suivantes :
 * <ul>
 * <li>idAgence, l'identifiant de l'agence � laquelle il est rattach�</li>
 * <li>lastName, son nom de famille</li>
 * <li>firstName son pr�nom</li>
 * </ul>
 * </div>
 * 
 *
 */
public class Actor {
	
	private String idAgence;
	private String lastName;
	private String firstName;

	public Actor(String adAgence, String lastName, String firstName) {
		super();
		this.idAgence = adAgence;
		this.lastName = lastName;
		this.firstName = firstName;
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


}
