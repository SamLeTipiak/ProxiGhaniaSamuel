package metier;

public class AccountSaving extends BankAccount{

//	qttribut
	private double rateAccount;
	
	
//	Constructeur
	public AccountSaving(long idClient, long numAccount, double sold, String openDate) {
		super(idClient, numAccount, sold, openDate);
		this.rateAccount = 3.0/100.0;
		super.type = BankAccount.etype.SAVING_ACCOUNT;
	}

//	Getter setter
	public double getRateAccount() {
		return rateAccount;
	}


	public void setRateAccount(double rateAccount) {
		this.rateAccount = rateAccount;
	}
	

	
	

}
