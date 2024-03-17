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

      
    public Patients getPatients(int Pid) throws SQLException {
        Patients st = null;
         try {

            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                    Statement stmt = conn.createStatement(); 
                    ResultSet rs = stmt.executeQuery("SELECT * FROM Technician WHERE tId="+ Pid);) {
                while (rs.next()) {
                    st = new Patients();
                    st.setPid(rs.getInt("PId"));
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
                    ResultSet rs = stmt.executeQuery("SELECT * FROM Patient");) {
                while (rs.next()) {
                    Patients st = new Patients();
                    st.setPid(rs.getInt("PId"));
                    st.setName(rs.getString("Name"));
                    st.setPhoneNumber(rs.getString("PhoneNumber"));
                    st.setDOB(rs.getString("DOB"));
                    st.setGender(rs.getString("Gender"));
                    st.setEmail(rs.getString("Email"));
                    st.setUserId(rs.getInt("UserId"));
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
                stmt.executeUpdate("INSERT INTO Patients (PId, Name, PhoneNumber, DOB, Gender, Email, UserId) "
                        + "VALUES ('"+ st.getPid()+"','"+ st.getName()+"','"+ st.getPhoneNumber()+"','"+ st.getDOB()+"','"+ st.getGender()+"', '"+ st.getEmail()+"', '"+ st.getUserId()+"');");
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {

        }
        return false;
    }

    public boolean updatePatient(Patients st) {
        try {
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                    Statement stmt = conn.createStatement(); 
                    ) {
                stmt.executeUpdate("UPDATE Patient SET Pid = '" +st.getPid()+ "',Name = '" +st.getName()+ "',PhoneNumber = '" +st.getPhoneNumber()+ "',DOB = '" +st.getDOB()+ "',Gender = '" +st.getGender()+ "', Email = '" + st.getEmail()+ "', UserId = '" + st.getUserId()+ "' WHERE (Id = '" + st.getPid()+"');");
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {

        }
        return false;
    }
}
