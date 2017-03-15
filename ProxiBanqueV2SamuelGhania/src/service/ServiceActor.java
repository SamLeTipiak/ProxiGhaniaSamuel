package service;

import java.util.Collection;

import dao.*;

import metier.Adviser;
import metier.Client;

public class ServiceActor {
	
	public static Adviser getAdviserByIdAdviser(Long idAdviser){
		return DAOactors.getAdviserById(idAdviser) ;
	
	}

	public static Collection<Client> getAllClient(){
		return DAOactors.getAllClient();
	}

}
