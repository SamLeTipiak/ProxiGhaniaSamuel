package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import metier.Adviser;
import metier.Client;

/**
 * @author Samuel Bouchet - Ghania Bouzemame
 * @version 2.0
 * 
 * <b>DAOactors est la classe permettant de récupérer la liste clients depuis la base de données ainsi que de vérifier la connexion d'un conseiller à l'application.</b>
 */
public class DAOactors implements IDAOactors {

	/**
	 * @param idAdviser
	 * @return adv
	 * 
	 * Cette méthode permet de vérifier que le login saisi par un utilisateur existe bien, puis que le mot de passe saisi est bien celui qui y est associé.
	 */
	public static Adviser getAdviserById(long idAdviser) {

		Adviser adv = new Adviser();
		
		Connection cnx = BDD.seConnecter();

		try {
			Statement stat = cnx.createStatement();

			String sql = "select * from adviser";
			ResultSet res = stat.executeQuery(sql);

			while (res.next()) {
				long idadv = res.getInt("idadviser");
				String idag = res.getString("idagence");
				String firstn = res.getString("firstname");
				String lastn = res.getString("lastname");
				String pswd = res.getString("password");

				adv = new Adviser(idadv, idag, lastn, firstn, pswd);
				if (idadv == idAdviser) {
					return adv;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return adv;
		} finally {
			BDD.seDeconnecter(cnx);
		}

		return adv;
	}

	/**
	 * @return listClient
	 * 
	 * retourne la liste des clients enregistrés en base de données.
	 */
	public static Collection<Client> getAllClient() {
		Connection cnx = BDD.seConnecter();

		Collection<Client> listClient = new ArrayList<>();

		Statement stat;
		try {
			stat = cnx.createStatement();
			String sql = "select idclient, adviser.idadviser, idagence, client.firstname,  client.lastname, address, zipcode, town, telnumber from client, adviser where adviser.idadviser = client.idadviser group by idclient";

			ResultSet res = stat.executeQuery(sql);
			while (res.next()) {
				long idcl = res.getInt("idclient");
				String idag = res.getString("adviser.idagence");
				long idadv = res.getInt("idadviser");
				String firstn = res.getString("firstname");
				String lastn = res.getString("lastname");
				String adr = res.getString("address");
				String cp = res.getString("zipcode");
				String town = res.getString("town");
				String pn = res.getString("telnumber");

				Client cli = new Client(idcl, idag, idadv, lastn, firstn, adr, cp, town, pn);
				listClient.add(cli);

			}
			return listClient;

		} catch (SQLException e) {
			e.printStackTrace();
			return listClient;
		} finally {
			BDD.seDeconnecter(cnx);
		}

	}

	/**
	 * @param idClient
	 * @return cli
	 * 
	 * retourne le client correspondant à l'identifiant passé en paramètre.
	 */
	public static Client getClientById(long idClient) {

		Client cli=new Client();;

		Connection cnx = BDD.seConnecter();


		Statement stat;
		try {
			stat = cnx.createStatement();
			String sql = "select idclient, adviser.idadviser, idagence, client.firstname,  client.lastname, address, zipcode, town, telnumber from client, adviser where adviser.idadviser = client.idadviser  group by idclient";

			ResultSet res = stat.executeQuery(sql);
			while (res.next()) {
				long idcl = res.getInt("idclient");
				String idag = res.getString("adviser.idagence");
				long idadv = res.getInt("idadviser");
				String firstn = res.getString("firstname");
				String lastn = res.getString("lastname");
				String adr = res.getString("address");
				String cp = res.getString("zipcode");
				String town = res.getString("town");
				String pn = res.getString("telnumber");
				
				if (idcl == idClient) {
					return new Client(idcl, idag, idadv, lastn, firstn, adr, cp, town, pn);
				}
			}
			return cli;

		} catch (SQLException e) {
			e.printStackTrace();
			return cli;
		} finally {
			BDD.seDeconnecter(cnx);
		}

	}
}
