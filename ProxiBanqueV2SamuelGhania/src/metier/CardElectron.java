package metier;

public class CardElectron extends BankCard{
	
	public CardElectron(long numCard, String passwordCard,long idClient) {
		super(numCard, passwordCard,idClient);
		super.type = BankCard.etype.ELECTRON;
	}
}
