package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import metier.AccountCurrent;
import metier.AccountSaving;
import metier.Adviser;
import metier.BankAccount;
import metier.CardElectron;
import metier.CardVisa;

public class DAOaccount implements IDAOaccount {

	public static AccountCurrent getCurrentAccount(Long idClient) {

		AccountCurrent ac = new AccountCurrent();

		Connection cnx = BDD.seConnecter();

		Statement stat;
		try {
			stat = cnx.createStatement();

			String sql = "select idclient, bankcard.idcurrentaccount, sold, opendate, cardnumber, cardtype, cardpassword from client, currentaccount, bankcard where  client.idcurrentaccount = currentaccount.idcurrentaccount and currentaccount.idcurrentaccount = bankcard.idcurrentaccount and idclient = "
					+ idClient + "  group by idclient";

			ResultSet res;

			res = stat.executeQuery(sql);

			while (res.next()) {
				long idcl = res.getInt("idclient");
				long idca = res.getInt("idcurrentaccount");
				double so = res.getFloat("sold");
				String date = res.getString("opendate");
				long cn = res.getInt("cardnumber");
				String typ = res.getString("cardtype");
				String psw = res.getString("cardpassword");

				if (typ.equals("VISA")) {
					ac = new AccountCurrent(idcl, idca, so, date, new CardVisa(cn, psw, idcl));
				} else {
					ac = new AccountCurrent(idcl, idca, so, date, new CardElectron(cn, psw, idcl));
				}

			}

			return ac;

		} catch (SQLException e) {
			e.printStackTrace();
			return ac;
		} finally {
			BDD.seDeconnecter(cnx);
		}

	}

	
	
	public static AccountSaving getSavingAccount(Long idClient) {

		AccountSaving sc = new AccountSaving();

		Connection cnx = BDD.seConnecter();

		Statement stat;
		try {
			stat = cnx.createStatement();

			String sql = "select idclient, bankcard.idcurrentaccount, sold, opendate, cardnumber, cardtype, cardpassword from client, currentaccount, bankcard where  client.idcurrentaccount = currentaccount.idcurrentaccount and currentaccount.idcurrentaccount = bankcard.idcurrentaccount and idclient = "
					+ idClient + "  group by idclient";

			ResultSet res;

			res = stat.executeQuery(sql);

			while (res.next()) {
				long idcl = res.getInt("idclient");
				long idca = res.getInt("idcurrentaccount");
				double so = res.getFloat("sold");
				String date = res.getString("opendate");
				long cn = res.getInt("cardnumber");

				sc = new AccountSaving(idcl, idca, so, date);

			}

			return sc;

		} catch (SQLException e) {
			e.printStackTrace();
			return sc;
		} finally {
			BDD.seDeconnecter(cnx);
		}

	}
	
	public static Collection<Long> getAllIdAccount() {

		Collection<Long> listId = new ArrayList<>();

		Connection cnx = BDD.seConnecter();

		Statement stat;
		try {
			stat = cnx.createStatement();

			String sql = "select idcurrentaccountfrom currentaccount";

			ResultSet res;

			res = stat.executeQuery(sql);

			while (res.next()) {
				long idca = res.getInt("idcurrentaccount");

			}

			return sc;

		} catch (SQLException e) {
			e.printStackTrace();
			return sc;
		} finally {
			BDD.seDeconnecter(cnx);
		}

	}
	

}
