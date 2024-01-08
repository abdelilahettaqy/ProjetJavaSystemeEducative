package lst.tpjava.phase_JDBC;
import lst.tpjava.phase_ArrayList.models.Departement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



import lst.tpjava.phase_ArrayList.models.Departement;
import lst.tpjava.phase_ArrayList.models.Enseignant;
import lst.tpjava.phase_ArrayList.services.DB;
import lst.tpjava.phase_ArrayList.services.DepartementServices;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static lst.tpjava.phase_ArrayList.services.DepartementServices.getAllDept;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/departement";
        String user = "root";
        String pwd = "";

        try {
            Connection cx = DriverManager.getConnection(url, user, pwd);
            System.out.println("bonne connexion");

            //createDept(cx);
            //insertDept(departement,cx);
            // deleteDept(1,cx);
            //selectdept(cx);
            //updateDept(departement,cx);

        } catch (SQLException e) {
            System.out.println("Bad connection");
            e.printStackTrace();//Affiche le nom ou bien quelle errore que vous avez .
        }
    }


    public static void insertDept(Departement dept, Connection cx) throws SQLException {
        String rep = "insert into departement (id, intitulé, idChef) values(?,?,?)";
        PreparedStatement stmt = cx.prepareStatement(rep);
        stmt.setInt(1, dept.getId());
        stmt.setString(2, dept.getIntitule());
        stmt.setInt(3, dept.getChef().getId());
        stmt.execute();
        System.out.println("L'insertion est terminer . ");
    }
    public static void createDept(Connection cx) throws SQLException {
        String requete = "create table IF NOT EXISTS departement \n" +
                "(id  primary key, \n" +
                "intitulé varchar(150) charset utf8 null,\n" +
                "idChef int,\n" +
                "foreign key (idChef) references Enseignant (id)\n" +
                ");";
        Statement stmt = cx.createStatement();
        stmt.execute(requete);
        System.out.println("Table departement est créé avec succès.");

    }


    public static void deleteDept(int id, Connection cx) throws SQLException {
        String requete = "DELETE FROM Departement WHERE IdDept = ?";
        PreparedStatement ps = cx.prepareStatement(requete);
        ps.setInt(1, id);
        ps.execute();
        System.out.println("Suppression terminer.");
    }



    public static ArrayList<Departement> selectdept(Connection cx) throws SQLException {
        String sql = "SELECT * FROM departement";
        ArrayList<Departement> departement = new ArrayList<>();
        Statement statement = cx.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            Departement newdepartement = new Departement();
            newdepartement.setId(result.getInt("id"));
            newdepartement.setIntitule(result.getString("intitulé"));
            Enseignant chef = new Enseignant();
            chef.setId(result.getInt("idChef"));
            newdepartement.setChef(chef);
            departement.add(newdepartement);
        }
        return departement;
    }



    public static void updateDept(Departement dept, Connection cx) throws SQLException {
        String requete = "UPDATE departement SET intitulé = ?, idChef = ? WHERE id = ?";
        try (PreparedStatement stmt = cx.prepareStatement(requete)) {
            stmt.setString(1, dept.getIntitule());
            stmt.setInt(2, dept.getChef().getId());
            stmt.setInt(3, dept.getId());
            stmt.executeUpdate();
            System.out.println("modification terminer ");
        }
    }

}



