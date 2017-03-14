package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import metier.Adviser;

public class DAOactors implements IDAOactors {

	public static Adviser getAdviserById(long idAdviser, Connection cnx) throws SQLException {

		Statement stat = cnx.createStatement();
		String sql = "select * from adviser";

		ResultSet res = stat.executeQuery(sql);
		while (res.next()) {
			long idadv = res.getInt("idadviser");
			String idag = res.getString("idagence");
			String firstn = res.getString("firstname");
			String lastn = res.getString("lastname");
			String pswd = res.getString("password");
			
			Adviser adv = new Adviser(idadv, idag, firstn, lastn, pswd);
			if (idadv == idAdviser) {
				return adv;
			}
		}

		return null;
	}

}
