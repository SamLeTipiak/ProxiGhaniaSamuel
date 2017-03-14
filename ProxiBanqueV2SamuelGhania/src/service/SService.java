package service;

import dao.DAO;

public class SService {

	public SService()
	{
		DAO.getInstance();
	}
	

	//public static void sendInfoToclient(long idClient, String info) {
		// System.out.println(" Info client : " + DAO.getInstance().getClientById(idClient).getLastName() + " " + info);
	//}
}
