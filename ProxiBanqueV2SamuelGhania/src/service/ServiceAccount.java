package service;




import dao.DAO;
import metier.*;

import metier.BankAccount.etype;

public class ServiceAccount {

//	public static void addAccountToClient(long idClient, BankAccount.etype type, long startSold) {
//
//		switch (type) {
//		case CURRENT_ACCOUNT:
//			DAO.getInstance().getClientById(idClient).addBankAccount(new AccountCurrent(idClient, startSold, "today"));
//			break;
//		case SAVING_ACCOUNT:
//			DAO.getInstance().getClientById(idClient).addBankAccount(new AccountSaving(idClient, startSold, "today"));
//			break;
//
//		}
//	}

//	public static void removeAccountToClient(long idClient, BankAccount.etype type) {
//		Client tmp = DAO.getInstance().getClientById(idClient);
//		tmp.removeBankAccount(tmp.getAccount(type));
//
//	}

	public static void updateOverdrawToClient(long idClient, long newOverdraft) {
		DAO.getInstance().getClientById(idClient).setOverdraftRate(newOverdraft);
	}


//	public static void transferAccoutToAccount(BankAccount host, BankAccount dest, long sold) {
//		
//			host.setSold(-sold);
//			dest.setSold(sold);
//			if (!checkRich(host))
//				DAO.getInstance().getClientById(dest.getIdClient()).setClientIsRich(false);
//			if (!checkOverdraft(dest))
//			{
//				if(checkRich(dest))
//					DAO.getInstance().getClientById(dest.getIdClient()).setClientIsRich(true);
//			}
//			else
//				SService.sendInfoToclient(host.getIdClient(), "Carfull you still overdraw , sold : "+dest.getSold());
//			
//		 if (!checkOverdraft(host))
//			SService.sendInfoToclient(host.getIdClient(), "Carfull you don't have enought money to make a transfert sold : "+host.getSold());
//	}

	public static boolean checkOverdraft(BankAccount myAccount) {
		System.out.println("ServiceAccount checkOverdraft "+myAccount.getNumAccount()+" sold "+myAccount.getSold()+" overdraft "+DAO.getInstance().getClientById(myAccount.getIdClient()).getOverdraftRate());
		if (myAccount.getSold()  > DAO.getInstance().getClientById(myAccount.getIdClient()).getOverdraftRate())
			return false;
		return true;
	}

//	public static boolean checkRich(BankAccount myAccount) {
//	//	System.out.println("Service account : checkRich : type of account = "+myAccount.getType()+" sold of account = "+myAccount.getSold());
//		
//		double tmpsold = myAccount.getSold();  
//		if (myAccount.getType() == etype.CURRENT_ACCOUNT)
//		{
//			if (DAO.getInstance().getClientById(myAccount.getIdClient()).getAccount(etype.SAVING_ACCOUNT) != null)
//				tmpsold += DAO.getInstance().getClientById(myAccount.getIdClient()).getAccount(etype.SAVING_ACCOUNT).getSold();
//		}
//		else if (myAccount.getType() == etype.SAVING_ACCOUNT)
//		{
//			if (DAO.getInstance().getClientById(myAccount.getIdClient()).getAccount(etype.CURRENT_ACCOUNT) != null)
//			{
//		//		System.out.println("");
//				tmpsold += DAO.getInstance().getClientById(myAccount.getIdClient()).getAccount(etype.CURRENT_ACCOUNT).getSold();
//			}
//			
//		}
//			
//		
//		if (tmpsold >= 500000l) // /!\ ATTENTION CHANGE TO STAITC VARIABLE
//			return true;
//		return false;
//	}

}
