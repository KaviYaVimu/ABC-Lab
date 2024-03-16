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
import Model.Patients;



/**
 *
 * @author kavin
 */
public class PatientsAccess {
    
    static final String DB_URL = "jdbc:mysql://localhost:3306/abc_laboratories";
    static final String USER = "root";
    static final String PASS = "";
    
    
        public PatientsAccess() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            
        }
    }

      
    public Patients getTechnician(int id) throws SQLException {
        Patients st = null;
         try {

            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                    Statement stmt = conn.createStatement(); 
                    ResultSet rs = stmt.executeQuery("SELECT * FROM Technician WHERE tId="+ id);) {
                while (rs.next()) {
                    st = new Patients();
                    st.setId(rs.getInt("Id"));
                    st.setName(rs.getString("Name"));
                    st.setDOB(rs.getString("DOB"));
                    st.setGender(rs.getString("Gender"));
                    st.setEmail(rs.getString("Email"));
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

    public List<Patients> getPatients() {
        List<Patients> Patients = new ArrayList<>();
         try {
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                    Statement stmt = conn.createStatement(); 
                    ResultSet rs = stmt.executeQuery("SELECT * FROM Technician");) {
                while (rs.next()) {
                    Patients st = new Patients();
                    st.setId(rs.getInt("Id"));
                    st.setName(rs.getString("Name"));
                    st.setEmail(rs.getString("email"));
                    st.setUserId(rs.getInt("uiId"));
                    Patients.add(st);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {

        }

     return Patients;
    }
    
    public boolean addPatient(Patients st) {
        try {
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                    Statement stmt = conn.createStatement(); 
                    ) {
                stmt.executeUpdate("INSERT INTO Patients (Name, email, uiId) "
                        + "VALUES ('"+ st.getName()+"',', '"+ st.getEmail()+"', '"+ st.getUserId()+"');");
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {

        }
        return false;
    }

    public boolean updateTechnician(Patients st) {
        try {
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                    Statement stmt = conn.createStatement(); 
                    ) {
                stmt.executeUpdate("UPDATE Technician SET Name = '" +st.getName()+ "', email = '" + st.getEmail()+ "', uiId = '" + st.getUserId()+ "' WHERE (tId = '" + st.getId() +"');");
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {

        }
        return false;
    }
    
    public boolean deletePatient(int id) {
        try {
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                    Statement stmt = conn.createStatement(); 
                    ) {
                stmt.executeUpdate("DELETE FROM Technician WHERE (tid = '"+ id + "');");
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {

        }
        return false;
    }
}
