/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Model.Prescription;



/**
 *
 * @author kavin
 */
public class PrescriptionAccess {
    
    static final String DB_URL = "jdbc:mysql://localhost:3306/abc_laboratories";
    static final String USER = "root";
    static final String PASS = "";
    
    
        public PrescriptionAccess() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            
        }
    }

      
    public Prescription getPrescription(int Presid) throws SQLException {
        Prescription st = null;
         try {

            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                    Statement stmt = conn.createStatement(); 
                    ResultSet rs = stmt.executeQuery("SELECT * FROM Prescription WHERE tId="+ Presid);) {
                while (rs.next()) {
                    st = new Prescription();
                    st.setPresid(rs.getInt("Presid"));
                    st.setResults(rs.getString("Results"));
                    st.setDocument(rs.getString("Document"));
                    st.setUserId(rs.getInt("UserId"));
                    break;
                 }
            } catch (SQLException e) {
                System.err.print(e);
                throw e;
            }

        } catch (SQLException e) {
            System.err.print(e);
            throw e;
        }

        return st;
    }

    public List<Prescription> getPrescription() {
        List<Prescription> Prescription = new ArrayList<>();
         try {
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                    Statement stmt = conn.createStatement(); 
                    ResultSet rs = stmt.executeQuery("SELECT * FROM Prescription");) {
                while (rs.next()) {
                    Prescription st = new Prescription();
                    st.setPresid(rs.getInt("Presid"));
                    st.setResults(rs.getString("Results"));
                    st.setDocument(rs.getString("Document"));
                    st.setUserId(rs.getInt("UserId"));
                    Prescription.add(st);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {

        }

     return Prescription;
    }
    
    public boolean addPrescription(Prescription st) {
        try {
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                    Statement stmt = conn.createStatement(); 
                    ) {
                stmt.executeUpdate("INSERT INTO Prescription (Presid, Result, Document, UserId) "
                        + "VALUES ('"+ st.getPresid()+"','"+ st.getResults()+"','"+ st.getDocument()+"', '"+ st.getUserId()+"');");
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {

        }
        return false;
    }

    public boolean updatePrescription(Prescription st) {
        try {
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                    Statement stmt = conn.createStatement(); 
                    ) {
                stmt.executeUpdate("UPDATE Prescription SET Presid = '" +st.getPresid()+ "',Results = '" +st.getResults()+"', Document = '" + st.getDocument()+ "', UserId = '" + st.getUserId()+ "' WHERE (PresId = '" + st.getPresid()+"');");
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {

        }
        return false;
    }
    
}

