
package service;

import dao.DAO;
import metier.*;

import metier.BankAccount.etype;

public class ServiceCard extends SService {

//	public static void addCardToClient(long idCl, BankCard.etype type) {
//
//		Client cl = DAO.getInstance().getClientById(idCl);
//
//		if (cl.getAccount(etype.CURRENT_ACCOUNT) != null) {
//
//			switch (type) {
//			case VISA:
//				cl.AddBankCard(new CardVisa(idCl));
//				break;
//			case ELECTRON:
//				cl.AddBankCard(new CardElectron(idCl));
//				break;
//			default:
//				System.out.println("Vous avez un problème");
//				break;
//			}
//
//			DAO.getInstance().addClient(cl);
//		}else SService.sendInfoToclient(idCl, " n'a pas de compte courrant donc on ne peut pas lui assigner de carte ! ");
//	}

}
