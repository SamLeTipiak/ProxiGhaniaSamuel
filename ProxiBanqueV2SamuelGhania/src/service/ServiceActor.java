package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.*;

import metier.Adviser;

public class ServiceActor {
	
	public static Adviser getAdviserByIdAdviser(Long idAdviser) throws SQLException{
		
		Connection cnx = BDD.seConnecter();
		Adviser adv = DAOactors.getAdviserById(idAdviser, cnx) ;
		BDD.seDeconnecter(cnx);
		return adv;
	}

	

}
