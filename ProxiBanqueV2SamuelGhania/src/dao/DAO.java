package dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import metier.*;

public class DAO implements IDAO {

	// Paramètres
	private HashMap<Long, Client> mapOfClient = new HashMap<>();
	private HashMap<String, Agence> mapOfAgence = new HashMap<>();
	private HashMap<Long, Adviser> mapOfAdviser = new HashMap<>();

	private long idClient = 1L;
	private long idAdvisor = 1L;
	private long idAgence = 1L;

	// Constructeur privé
	private DAO() {

	}

	// Instance unique non préinitialisée.
	private static DAO INSTANCE = null;

	// Point d'acces pour l'instance unique du singleton.
	public static DAO getInstance() {
		if (INSTANCE == null)
			INSTANCE = new DAO();
		return INSTANCE;
	}

	// Getters

	public Collection<Client> getMapOfClient() {
		return mapOfClient.values();
	}

	public Collection<Agence> getMapOfAgence() {
		return mapOfAgence.values();
	}

	public Collection<Adviser> getMapOfAdviser() {
		return mapOfAdviser.values();
	}

	// Méthode qui retourne un conseiller qui
	// n'a pas sa liste de client pleine
//	@Override
//	public Adviser getAdviserDispo() {
//		Collection<Adviser> listAdviser = new ArrayList<>();
//		listAdviser = mapOfAdviser.values();
//		for (Iterator<Adviser> iterator = listAdviser.iterator(); iterator.hasNext();) {
//			Adviser ad = iterator.next();
//			if (ad.isAviableToNewClient())
//				return ad;
//		}
//		return null;
//	}

	// Retourne un identifiant (en vérifiant qu'il est nouveau

	@Override
	public long genIdAgence() {
		return idAgence++;
	}

	@Override
	public long genIdClient() {
		return idClient++;
	}

	@Override
	public long genIdAdviser() {
		return idAdvisor++;
	}

	// Ajouter client, conseiller,agence.
//	@Override
//	public void addClient(Client cl) {
//		mapOfClient.put(cl.getId(), cl);
//	}

//	@Override
//	public void addAdviser(Adviser ad) {
//		mapOfAdviser.put(ad.getId(), ad);
//	}

	@Override
	public void addAgence(Agence ag) {
		mapOfAgence.put(ag.getId(), ag);
	}

	// Enlever Client,conseiller, agence.
//	@Override
//	public void removeClient(Client cl) {
//		mapOfClient.remove(cl.getId());
//	}

//	@Override
//	public void removeAdviser(Adviser ad) {
//		mapOfAdviser.remove(ad.getId());
//	}

	@Override
	public void removeAgence(Agence ag) {
		mapOfAgence.remove(ag.getId());
	}

	// Renvoie un client avec l'id
	@Override
	public Client getClientById(Long id) {
		Collection<Client> listClient = new ArrayList<>();
		listClient = mapOfClient.values();
		for (Iterator<Client> iterator = listClient.iterator(); iterator.hasNext();) {
			Client cl = iterator.next();
			if (cl.getIdClient() == id)
				return cl;
		}
		return null;
	}

	// Retourne tous les clients d'une agence donnée
	@Override
	public List<Client> getClientOfAgence(String id) {
		
		List<Client> listCOA = new ArrayList<>(); 
		
		Collection<Client> listClient = new ArrayList<>();
		listClient = mapOfClient.values();
		for (Iterator<Client> iterator = listClient.iterator(); iterator.hasNext();) {
			Client cl = iterator.next();
			if (cl.getIdAgence().equals(id))
				listCOA.add(cl);
		}
		return listCOA;
	}

	@Override
	public Agence getAgenceById(String id) {
		Collection<Agence> listAgence = new ArrayList<>();
		listAgence = mapOfAgence.values();
		for (Iterator<Agence> iterator = listAgence.iterator(); iterator.hasNext();) {
			Agence ag = iterator.next();
			if (ag.getId().equals(id))
				return ag;
		}
		return null;
	}

	public void setMapOfClient(HashMap<Long, Client> mapOfClient) {
		this.mapOfClient = mapOfClient;
	}

	public void setMapOfAgence(HashMap<String, Agence> mapOfAgence) {
		this.mapOfAgence = mapOfAgence;
	}

	public void setMapOfAdviser(HashMap<Long, Adviser> mapOfAdviser) {
		this.mapOfAdviser = mapOfAdviser;
	}

	//

}
