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
import Model.Appointment;

/**
 *
 * @author kavin
 */
public class AppointmentAccess {
    
    static final String DB_URL = "jdbc:mysql://localhost:3306/abc_laboratories";
    static final String USER = "root";
    static final String PASS = "";
    
    
        public AppointmentAccess() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            
        }
    }
          public Appointment getAppointment(int APid) throws SQLException {
        Appointment st = null;
         try {

            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                    Statement stmt = conn.createStatement(); 
                    ResultSet rs = stmt.executeQuery("SELECT * FROM Appointment WHERE APid="+ APid);) {
                while (rs.next()) {
                    st = new Appointment();
                    st.setAPid(rs.getInt("APid"));
                    st.setName(rs.getString("Name"));
                    st.setPhoneNumber(rs.getString("phoneNumber"));
                    st.setReportType(rs.getString("ReportType"));
                    st.setGender(rs.getString("Gender"));
                    st.setEmail(rs.getString("Email"));
                    st.setAppointmentTime(rs.getString("AppointmentTime"));
                    st.setAppointmentDate(rs.getString("AppointmentDate"));
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

           public List<Appointment> getAppointment() {
        List<Appointment> Appointment = new ArrayList<>();
         try {
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                    Statement stmt = conn.createStatement(); 
                    ResultSet rs = stmt.executeQuery("SELECT * FROM Appointment");) {
                while (rs.next()) {
                    Appointment st = new Appointment();
                    st.setAPid(rs.getInt("APid"));
                    st.setName(rs.getString("Name"));
                    st.setPhoneNumber(rs.getString("PhoneNumber"));
                    st.setReportType(rs.getString("ReportType"));
                    st.setGender(rs.getString("Gender"));
                    st.setEmail(rs.getString("Email"));
                    st.setAppointmentTime(rs.getString("AppointmentTime"));
                    st.setAppointmentDate(rs.getString("AppointmentDate"));
                    st.setUserId(rs.getInt("UserId"));
                    Appointment.add(st);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {

        }

        return Appointment;
    }
           
            public boolean addAppointment(Appointment st) {
        try {
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                    Statement stmt = conn.createStatement(); 
                    ) {
                stmt.executeUpdate("INSERT INTO Appointment (Id, Name, phoneNumber, ReportType, Gender, Email, AppointmentTime, AppointmentDate, UserId) "
                        + "VALUES ('"+ st.getAPid()+"','"+ st.getName()+"', '"+ st.getPhoneNumber()+"','"+ st.getReportType()+"','"+ st.getGender()+"','"+ st.getEmail()+"','"+ st.getAppointmentTime()+"','"+ st.getAppointmentDate()+"','"+ st.getUserId()+"';");
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {

        }
        return false;
    }
            
              public boolean updateAppointment(Appointment st) {
        try {
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                    Statement stmt = conn.createStatement(); 
                    ) {
                stmt.executeUpdate("UPDATE Appointment SET ID = '" +st.getAPid()+ "', Name = '" + st.getName()+ "', PhoneNumber = '" + st.getPhoneNumber()+ "', ReportType = '" + st.getReportType()+ "', Gender = '" + st.getGender()+ "', Email = '" + st.getEmail()+ "', AppointmentTime = '" + st.getAppointmentDate()+ "' WHERE (UserId = '" + st.getUserId() +"');");
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {

        }
        return false;
    }
              

}
