package service;

import java.util.Collection;

import dao.DAO;
import metier.*;
//import metier.BankAccount.etype;

/**
 * @author Jonas Samuel
 *
 */
public class ActorService extends SService {

	// BDD action

	/*
	 * Mets ajour le client sur la basse de données
	 */
//	public static void updateClientToBDD(Client cl) {
//		DAO.getInstance().addClient(cl);
//	}

	/**
	 * Ajout du client dans la base de données, ajout du client dans la liste
	 * des clients d'un conseiller SI en existe de disponible le client reçoit
	 * alors l'identifiant de ce conseiller SINON aucun conseiller ne lui est
	 * attribué
	 * 
	 * @param cl
	 *            = nouveau client
	 */
//	public static void addNewClient(Client cl) {
//		Adviser adtmp = DAO.getInstance().getAdviserDispo();
//		if (adtmp != null) {
//			adtmp.addClient(cl);
//			cl.setIdAgence(adtmp.getIdAgence());
//		}
//		DAO.getInstance().addClient(cl);
//	}

	/**
	 * Supprime un client de la base de données
	 * 
	 * @param cl
	 */
//	public static void removeClient(Client cl) {
//		DAO.getInstance().removeClient(cl);
//	}

	/**
	 * Ajoute un conseiller à la base de données
	 * 
	 * @param ad
	 */
//	public static void addAdviserToBDD(Adviser ad) {
//		DAO.getInstance().getAgenceById(ad.getIdAgence()).AddAdviser(ad);
//		DAO.getInstance().addAdviser(ad);
//
//	}

	/**
	 * Supprime un conseiller de la base de données
	 * 
	 * @param ad
	 */
//	public static void removeAdviserToBDD(Adviser ad) {
//		DAO.getInstance().removeAdviser(ad);
//		DAO.getInstance().getAgenceById(ad.getIdAgence()).AddAdviser(ad);
//	}

	/**
	 * Ajoute une agence à la base de données
	 * 
	 * @param ag
	 */
	public static void addAgenceToBDD(Agence ag) {
		DAO.getInstance().addAgence(ag);
	}

	/*
	 * Supprime un agence de la base de données
	 */
	public static void removeAgenceToBDD(Agence ag) {
		DAO.getInstance().removeAgence(ag);
	}

	/*
	 * @return un identifiant généré pour un consiller
	 */
	public static long genIdAdviser() {
		return DAO.getInstance().genIdAdviser();

	}

	/*
	 * @return un identifiant généré pour un client
	 */
	public static long genIdClient() {
		return DAO.getInstance().genIdClient();

	}

	/**
	 * 
	 * @return un identifiant généré pour une agence
	 */
	public static String genIdAgence() {
		return Long.toString(DAO.getInstance().genIdAgence());

	}

	/**
	 * 
	 * @return Retourne un texte présentant les informations importantes d'une agence
	 */
	public static String getAllAgence()
	{
		DAO daotmp = DAO.getInstance();
		String ret = "";
		Collection<Agence> tmp = daotmp.getMapOfAgence();
		for (Agence agence : tmp) {
			ret += " Agence "+agence.getId()+" | Ouverte le "+agence.getOpenDate();
		if (agence.getCurrentDirector() != null)
		{
			ret += " | Diriger par "+agence.getCurrentDirector().getLastName();
		}
			ret += " | il y a "+agence.getCurrentListOfAdviser().size()+" conseiller \n";
		}
		return ret;
	}

	/**
	 * 
	 * @return Retourne un texte présentant les informations importantes du
	 *         conseiller
	 */
	public static String getAllAdvier() {
		DAO daotmp = DAO.getInstance();
		String ret = "";
		Collection<Adviser> tmp = daotmp.getMapOfAdviser();
		for (Adviser adviser : tmp) {
			ret += " Conseiller : " + adviser.getLastName() + " " + adviser.getFirstName() + " | de l'agence"
					+ adviser.getIdAgence() + " | son numéro est le : " + adviser.getCellphone()
					+ " | Nombre de client :" + adviser.getListOfClient().size() + "\n";
		}
		return ret;
	}

	/**
	 * 
	 * @return Retourne un texte présentant les informations importantes du
	 *         client
	 */
//	public static String getAllClient() {
//		DAO daotmp = DAO.getInstance();
//		String ret = "";
//		Collection<Client> tmp = daotmp.getMapOfClient();
//		for (Client client : tmp) {
//			ret += " Client : " + client.getLastName() + " " + client.getFirstName() + " | de l'agence"
//					+ client.getIdAgence() + " | son numéro est le : " + client.getCellphone() + " | Adresse : "
//					+ client.getAddress() + " " + client.getZipCode() + " " + client.getTown() + "\n";
//			if (client.getAccount(etype.CURRENT_ACCOUNT) != null)
//				ret += " Compte courrant : " + client.getAccount(etype.CURRENT_ACCOUNT).getNumAccount() + " | solde : "
//						+ client.getAccount(etype.CURRENT_ACCOUNT).getSold() + "\n";
//			if (client.getAccount(etype.SAVING_ACCOUNT) != null)
//				ret += " Compte épargne : " + client.getAccount(etype.SAVING_ACCOUNT).getNumAccount() + " | solde : "
//						+ client.getAccount(etype.SAVING_ACCOUNT).getSold() + "\n";
//			if (client.getCurrentCard() != null)
//				ret += " Carte banquaire No : " + client.getCurrentCard().getNumCard() + "\n";
//		}
//		return ret;
//	}

}
