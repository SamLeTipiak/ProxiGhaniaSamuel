package service;

import java.util.List;

import dao.DAO;
import metier.*;

import metier.BankAccount.etype;

public class ServiceAudit extends SService {

	private static double valueAuditCasual = -5000.0;
	private static double valueAuditEntreprise = -50000.0;

	public static void doAudit(String idAg) {
		List<Client> listClient = DAO.getInstance().getClientOfAgence(idAg);
		System.out.println(listClient.toString());
		for (Client client : listClient) {
			System.out.println(" a ");
			double solde = 0.0;
			switch (client.getType()) {
			case CASUAL:
				solde = client.getAccount(etype.CURRENT_ACCOUNT).getSold();
				System.out.println("solde"+ solde);
				if (solde < valueAuditCasual)
					System.out.println("Le client " + client.getFirstName() + " " + client.getLastName()
							+ " a un solde de :" + solde);
				break;
			case ENTERPRISE:
				solde = client.getAccount(etype.CURRENT_ACCOUNT).getSold();
				System.out.println("solde"+ solde);
				if (solde < valueAuditEntreprise)
					System.out.println("L'entreprise " + client.getFirstName() + " " + client.getLastName()
							+ " a un solde de :" + solde);
				break;
			default:
				System.out.println("Rien ne va plus");
				break;
			}
		}

	}

	public void changeValues(double vAC, double vAE) {
		valueAuditCasual = vAC;
		valueAuditEntreprise = vAE;
	}

}
