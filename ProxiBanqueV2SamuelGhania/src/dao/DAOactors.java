package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import metier.Adviser;
import metier.Client;

public class DAOactors implements IDAOactors {

	public static Adviser getAdviserById(long idAdviser) {

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

				Adviser adv = new Adviser(idadv, idag, lastn, firstn,  pswd);
				if (idadv == idAdviser) {
					return adv;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			BDD.seDeconnecter(cnx);
		}

		return null;
	}

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

}
