package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import metier.AccountCurrent;
import metier.Adviser;

public class DAOaccount implements IDAOaccount {

	
	public static AccountCurrent getCurrentAccount(Long idClient) {
		
		Connection cnx = BDD.seConnecter();

		Statement stat;
		try {
			stat = cnx.createStatement();

			String sql = "select * from currentaccount";

			ResultSet res;

			res = stat.executeQuery(sql);

			AccountCurrent ac;
			
			while (res.next()) {
				long idcl = res.getInt("idclient");
				long idca = res.getInt("idcurrentaccount");
				double so = res.getFloat("sold");
				String date = res.getString("opendate");
				long cn = res.getInt("cardnumber");
				String typ = res.getString("type");
				
				
				
				if (typ.equals("VISA")) {
					ac = new AccountCurrent(idcl, idca, so, date,new CardVisa());
				}else{
					
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
	
}
