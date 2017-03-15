package service;

import java.util.Collection;

import dao.*;

import metier.Adviser;
import metier.Client;

public class ServiceActor {
	
	public static Adviser getAdviserByIdAdviser(Long idAdviser){
		if (idAdviser instanceof Long){
		return DAOactors.getAdviserById(idAdviser) ;
		}else {
			return new Adviser();
		}
		
	
	}

	public static Collection<Client> getAllClient(){
		return DAOactors.getAllClient();
	}

}
