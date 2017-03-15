package metier;

/**
 * @author Samuel Bouchet - Ghania Bouzemame
 * @version 2.0
 *
 *          <b>AccountSaving est la classe représentant les comptes épargne,
 *          elle étend la classe BankAccount et hérite donc de ses propriétés et
 *          méthodes.</b>
 *
 * @see Actor
 *
 *      <div>Chaque compte épargne dispose de la propriété spécifique suivante :
 *      rateAccount, le taux de rémunération du compte. </div>
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
