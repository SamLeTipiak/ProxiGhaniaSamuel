package metier;

public class CardVisa extends BankCard{

	public CardVisa(long numCard, int passwordCard,long idClient) {
		super(numCard, passwordCard, idClient);
		super.type = BankCard.etype.VISA;
	}

}
