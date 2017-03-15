package service;

import dao.DAO;
import dao.DAOaccount;
import metier.*;


public class ServiceAccount {

	public static AccountCurrent getCurrentAccountById(long idClient) {
		return DAOaccount.getCurrentAccount(idClient);
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
