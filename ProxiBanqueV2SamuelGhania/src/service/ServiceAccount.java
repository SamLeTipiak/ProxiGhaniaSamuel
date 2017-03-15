package service;

import java.util.List;

import dao.DAO;
import dao.DAOaccount;
import metier.*;

public class ServiceAccount {

	public static AccountCurrent getCurrentAccountById(long idClient) {
		return DAOaccount.getCurrentAccount(idClient);
	}

	public static Boolean accountTransfer(long debitAccount, long creditAccount, double somme) {
		List<Long> listeId = (List<Long>) DAOaccount.getAllIdAccount();

		for (Long long1 : listeId) {
			if (long1 == debitAccount) {
				for (Long long2 : listeId) {
					if (long2 == creditAccount) {
						DAOaccount.updateSold(somme, creditAccount);
						DAOaccount.updateSold(-somme, debitAccount);

						return true;
					}
				}
			}
		}

		return false;
	}

	public static AccountSaving getSavingAccountById(long idClient) {
		return DAOaccount.getSavingAccount(idClient);
	}

	public static void updateOverdrawToClient(long idClient, long newOverdraft) {
		DAO.getInstance().getClientById(idClient).setOverdraftRate(newOverdraft);
	}

	public static boolean checkOverdraft(BankAccount myAccount) {
		System.out.println("ServiceAccount checkOverdraft " + myAccount.getNumAccount() + " sold " + myAccount.getSold()
				+ " overdraft " + DAO.getInstance().getClientById(myAccount.getIdClient()).getOverdraftRate());
		if (myAccount.getSold() > DAO.getInstance().getClientById(myAccount.getIdClient()).getOverdraftRate())
			return false;
		return true;
	}

}
