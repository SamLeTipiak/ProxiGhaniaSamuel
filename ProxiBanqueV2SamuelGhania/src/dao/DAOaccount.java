package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import metier.AccountCurrent;
import metier.AccountSaving;
import metier.CardElectron;
import metier.CardVisa;

/**
 * @author Samuel Bouchet - Ghania Bouzemame
 * @version 2.0
 * 
 *          <b>DAOaccount est la classe dans laquelle sont présentes les
 *          méthodes permettant de récupérer les comptes clients depuis la base
 *          de données.</b>
 * 
 */
public class DAOaccount implements IDAOaccount {

	/**
	 * @param idClient

	 * @return ac retourne le compte courant du client correspondant à l'identifiant passé en paramètre.

	 * @return ac retourne le compte courant du client correspondant à
	 *         l'identifiant passé en paramètre

	 */
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

	/**
	 * @param idClient

	 * @return sc retourne le compte épargne du client correspondant à l'identifiant passé en paramètre.

	 * @return sc retourne le compte épargne du client correspondant à
	 *         l'identifiant passé en paramètre
	 */

	public static AccountSaving getSavingAccount(Long idClient) {

		AccountSaving sc = new AccountSaving();

		Connection cnx = BDD.seConnecter();

		Statement stat;
		try {
			stat = cnx.createStatement();

			String sql = "select idclient, client.idsavingaccount, sold, opendate from client, savingaccount where  client.idsavingaccount = savingaccount.idsavingaccount and idclient = "
					+ idClient + "  group by idclient";

			ResultSet res;

			res = stat.executeQuery(sql);

			while (res.next()) {
				long idcl = res.getInt("idclient");
				long idsa = res.getInt("idsavingaccount");
				double so = res.getFloat("sold");
				String date = res.getString("opendate");

				sc = new AccountSaving(idcl, idsa, so, date);

			}

			return sc;

		} catch (SQLException e) {
			e.printStackTrace();
			return sc;
		} finally {
			BDD.seDeconnecter(cnx);
		}

	}

	/**
	 * @return lisId 
	 * retourne la liste de tous les numéros de comptes afin de vérifier qu'ils existent bien au sein de la banque avant d'effectuer un virement.
	 *
	 */
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
				listId.add(idca);
			}

			sql = "select idsavingaccountfrom savingaccount";

			res = stat.executeQuery(sql);

			while (res.next()) {
				long idsa = res.getInt("idsavingaccount");
				listId.add(idsa);
			}

			return listId;

		} catch (SQLException e) {
			e.printStackTrace();
			return listId;
		} finally {
			BDD.seDeconnecter(cnx);
		}

	}

	public static void updateSold(double somme, long id) {
		Connection cnx = BDD.seConnecter();

		try {

			if (id < 999) {

				String sql = "update currentaccount set sold = sold + ? where idclient=?";
				PreparedStatement stat = cnx.prepareStatement(sql);
				stat.setDouble(1, somme);
				stat.setLong(2, id);
				stat.executeUpdate();
			} else {
				String sql2 = "update savingaccount set sold = sold + ? where idclient=?";
				PreparedStatement stut = cnx.prepareStatement(sql2);
				stut.setDouble(1, somme);
				stut.setLong(2, id);
				stut.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BDD.seDeconnecter(cnx);
		}
	}

}
