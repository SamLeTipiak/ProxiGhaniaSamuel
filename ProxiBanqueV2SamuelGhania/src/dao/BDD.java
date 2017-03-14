package dao;



import java.sql.Connection;
import java.sql.DriverManager;


public class BDD {

    public static Connection seConnecter() {
        Connection cnx = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection("jdbc:MySQL://localhost/ProxiBanque", "root", "");

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
