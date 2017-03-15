package metier;

/**
 * @author Samuel Bouchet - Ghania Bouzemame
 * @version 2.0
 *
 *          <b>AccountCurrent est la classe repr�sentant les comptes courants,
 *          elle �tend la classe BankAccount et h�rite donc de ses propri�t�s et
 *          m�thodes.</b>
 *
 * @see Actor
 *
 *      <div>Chaque compte courant dispose des propri�t�s sp�cifiques suivantes
 *      :
 *      <ul>
 *      <li>isOverdraw, un bool�en disant si oui ou non le client est �
 *      d�couvert</li>
 *      <li>card, la carte banquaire associ�e</li>
 *      </ul>
 *      </div>
 *
 */
public class AccountCurrent extends BankAccount {

	// qttribut

	private boolean isOverdraw;
	private BankCard card;

	// Constructeur
	public AccountCurrent(long idClient, long numAccount, double sold, String openDate, BankCard card) {
		super(idClient, numAccount, sold, openDate);
		this.isOverdraw = false;
		this.card = card;
		super.type = BankAccount.etype.CURRENT_ACCOUNT;
	}

	public AccountCurrent() {
		super();
	}

	// Getter setter

	public boolean isOverdraw() {
		return isOverdraw;
	}

	public void setOverdraw(boolean isOverdraw) {
		this.isOverdraw = isOverdraw;
	}

	public BankCard getCard() {
		return card;
	}

	public void setCard(BankCard card) {
		this.card = card;
	}

}
