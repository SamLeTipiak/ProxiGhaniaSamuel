package metier;

public class CardVisa extends BankCard{

	public CardVisa(long numCard, String passwordCard,long idClient) {
		super(numCard, passwordCard, idClient);
		super.type = BankCard.etype.VISA;
	}

}
