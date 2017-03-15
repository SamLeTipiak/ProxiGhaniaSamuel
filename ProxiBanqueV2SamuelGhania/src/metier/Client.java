package metier;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Samuel Bouchet - Ghania Bouzemame
 * @version 2.0
 *
 *          <b>Client est la classe représentant les clients de la banque, elle
 *          étend la classe Actor et hérite donc de ses propriétés et méthodes.</b>
 *
 *@see Actor
 *
 *      <div>Chaque client est représenté par les propriétés spécifiques suivantes :
 *      <ul>
 *      <li>idClient, l'identifiant du client au sein de la banque</li>
 *      <li>idAdviser, l'identifiant du conseiller auquel il est rattaché</li>
 *      <li>address, l'adresse physique du client</li>
 *      <li>zipCode, son code postal</li>
 *      <li>town, sa ville</li>
 *      <li>telNumber, son numéro de téléphone</li>
 *      </ul>
 *      </div>
 *
 *
 */
public class Client extends Actor {

	private long idClient;
	private long idAdviser;
	private String address;
	private String zipCode;
	private String town;
	private String telNumber;

	private List<BankAccount> listOfAccount = new ArrayList<>();

	protected double overdraftRate;

	public enum etype {
		CASUAL, ENTERPRISE;
	}

	protected etype type;

	public Client(long idClient, String idAgence, long idAviser, String lastName, String firstName, String telNumber,
			String adress, String zipCode, String town) {
		super(idAgence, lastName, firstName);
		this.idClient = idClient;
		this.idAdviser = idAviser;
		this.address = adress;
		this.zipCode = zipCode;
		this.town = town;
		this.telNumber = telNumber;
	}
	
	public Client(){
		super();
	}

	public long getIdAdviser() {
		return idAdviser;
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

	
	public void setIdAdviser(long idAviser) {
		this.idAdviser = idAviser;
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


	@Override
	public String toString() {
		return "Client [idAdviser=" + idAdviser + ", address=" + address + ", zipCode=" + zipCode + ", town=" + town
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
