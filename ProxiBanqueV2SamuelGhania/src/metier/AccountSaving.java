package metier;

/**
 * @author Samuel Bouchet - Ghania Bouzemame
 * @version 2.0
 *
 *          <b>AccountSaving est la classe repr�sentant les comptes �pargne,
 *          elle �tend la classe BankAccount et h�rite donc de ses propri�t�s et
 *          m�thodes.</b>
 *
 * @see Actor
 *
 *      <div>Chaque compte �pargne dispose de la propri�t� sp�cifique suivante :
 *      rateAccount, le taux de r�mun�ration du compte. </div>
 */
public class AccountSaving extends BankAccount {

	// qttribut
	private double rateAccount;

	// Constructeur
	public AccountSaving(long idClient, long numAccount, double sold, String openDate) {
		super(idClient, numAccount, sold, openDate);
		this.rateAccount = 3.0 / 100.0;
		super.type = BankAccount.etype.SAVING_ACCOUNT;
	}

	public AccountSaving() {
		super();
	}

	// Getter setter
	public double getRateAccount() {
		return rateAccount;
	}

	public void setRateAccount(double rateAccount) {
		this.rateAccount = rateAccount;
	}

}
