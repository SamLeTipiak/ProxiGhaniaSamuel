
package metier;

/**
 * @author Samuel Bouchet - Ghania Bouzemame
 * @version 2.0
 * 
 *          <b>BankAccount est la classe repr�sentant les comptes clients.</b>
 * 
 *          <div>Chaque compte est caract�ris� par les propri�t�s suivantes :
 *          <ul>
 *          <li>idClient, l'identifiant du client au sein de la banque</li>
 *          <li>numAccount, le num�ro du compte</li>
 *          <li>sold, le solde du compte</li>
 *          <li>openDate, la date d'ouverture du compte</li>
 *          <li>type, le type de compte, courant ou �pargne</li>
 *          </ul>
 *          </div>
 *
 */
public class BankAccount {

	// attributs
	private long idClient;
	private long numAccount;
	private double sold;
	private String openDate;


	public enum etype {
		CURRENT_ACCOUNT, SAVING_ACCOUNT
	};

	protected etype type;

	// constructeur

	public etype getType() {
		return type;
	}

	public BankAccount(long idClient, long numAccount, double sold, String openDate) {
		super();
		this.idClient = idClient;
		this.numAccount = numAccount;
		this.sold = sold;
		this.openDate = openDate;
	}

	public BankAccount() {
		super();
	}

	// Getters setters
	public double getSold() {
		return sold;
	}

	public void setSold(double sold) {
		this.sold += sold;
	}

	public long getIdClient() {
		return idClient;
	}

	public long getNumAccount() {
		return numAccount;
	}

	public String getOpenDate() {
		return openDate;
	}

}
