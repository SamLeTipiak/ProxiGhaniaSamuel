package dao;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 * @author Samuel Bouchet - Ghania Bouzemame
 * @version 2.0
 * 
 * <b>BDD est la classe qui permet la connexion et la deconnexion à la base de données.</b>
 * 
 *
 */
public class BDD {

    public static Connection seConnecter() {
        Connection cnx = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection("jdbc:MySQL://localhost/proxibanque", "root", "");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cnx;
    }

    public static void seDeconnecter(Connection cnx) {
        try {
            cnx.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
