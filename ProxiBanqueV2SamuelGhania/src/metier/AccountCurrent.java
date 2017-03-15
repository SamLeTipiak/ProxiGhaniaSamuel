package metier;

public class AccountCurrent extends BankAccount{

//	qttribut
	
	private boolean isOverdraw;
	private BankCard card;
	
	
//	Constructeur
	public AccountCurrent(long idClient, long numAccount, double sold, String openDate, BankCard card) {
		super(idClient, numAccount, sold, openDate);
		this.isOverdraw = false;
		this.card=card;
	super.type = BankAccount.etype.CURRENT_ACCOUNT;
	}


//	Getter setter	



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
