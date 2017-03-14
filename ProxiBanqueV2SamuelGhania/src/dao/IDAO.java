package dao;

import java.util.List;

import metier.*;

public interface IDAO {
	
//	public Adviser getAdviserDispo();
	public long genIdAgence();
	public long genIdClient();
	public long genIdAdviser();
//	public void addClient(Client cl);
//	public void addAdviser(Adviser ad);
	public void addAgence(Agence ag);
//	public void removeClient(Client cl);
//	public void removeAdviser(Adviser ad);
	public void removeAgence(Agence ag);
	public Client getClientById(Long id);
	public List<Client> getClientOfAgence(String id);
	public Agence getAgenceById(String id);
}
