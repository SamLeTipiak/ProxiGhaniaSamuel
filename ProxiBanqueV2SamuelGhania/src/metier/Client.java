package metier;


import java.util.ArrayList;
import java.util.List;


public class Client extends Actor {

	private long idClient;
	private long idAviser;
	private String address;
	private String zipCode;
	private String town;
	private String telNumber;

	private List<BankAccount> listOfAccount = new ArrayList<>();


	protected double overdraftRate;
	
	
	public enum etype{
		CASUAL,ENTERPRISE;
	}
	protected etype type;

	public Client(long idClient, String idAgence, String lastName, String firstName, String telNumber, String adress,
			String zipCode, String town) {
		super(idAgence, lastName, firstName);
		this.address = adress;
		this.zipCode = zipCode;
		this.town = town;
		this.telNumber = telNumber;
	}

	public long getIdAviser() {
		return idAviser;
	}

	public String getAddress() {
		return address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getTown() {
		return town;
	}

	public List<BankAccount> getListOfAccount() {
		return listOfAccount;
	}

//	public void addBankAccount(BankAccount ba) {
//		this.listOfAccount.add(ba);
//	}

//	public void AddBankCard(BankCard bc) {
//		this.currentCard = bc;
//	}
//
//	public void removeBankAccount(BankAccount ba) {
//		this.listOfAccount.remove(ba);
//	}
//
//	public boolean isClientIsRich() {
//		return clientIsRich;
//	}
//
//	public BankCard getCurrentCard() {
//		return currentCard;
//	}

	public void setIdAviser(long idAviser) {
		this.idAviser = idAviser;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public void setTown(String town) {
		this.town = town;
	}
	
	public etype getType() {
		return type;
	}

	public void setType(etype type) {
		this.type = type;
	}


	public double getOverdraftRate() {
		return overdraftRate;
	}

	public void setOverdraftRate(double overdraftRate) {
		this.overdraftRate = overdraftRate;
	}

//	public BankAccount getAccount(BankAccount.etype type) {
//
//		if (this.listOfAccount.size() > 0) {
//
//			for (BankAccount bankAccount : this.listOfAccount) {
//				if (bankAccount.getType().equals(type)) {
//					//System.out.println("Client getAccount by type : "+type+" = "+bankAccount);
//					return  bankAccount;
//				}
//			}
//		}
//		return null;
//	}

	@Override
	public String toString() {
		return "Client [idAviser=" + idAviser + ", address=" + address + ", zipCode=" + zipCode + ", town=" + town
				+ ", listOfAccount=" + listOfAccount + ", overdraftRate=" + overdraftRate + "]";
	}

	public long getIdClient() {
		return idClient;
	}

	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public void setListOfAccount(List<BankAccount> listOfAccount) {
		this.listOfAccount = listOfAccount;
	}

}
