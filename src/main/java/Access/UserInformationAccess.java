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
import Model.UserInformation;



/**
 *
 * @author kavin
 */
public class UserInformationAccess {
    
    static final String DB_URL = "jdbc:mysql://localhost:3306/abc_laboratories";
    static final String USER = "root";
    static final String PASS = "";
    
    
        public UserInformationAccess() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            
        }
    }

      
    public UserInformation getUserInformation(int Pid) throws SQLException {
        UserInformation st = null;
         try {

            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                    Statement stmt = conn.createStatement(); 
                    ResultSet rs = stmt.executeQuery("SELECT * FROM UserInformation WHERE tId="+ Pid);) {
                while (rs.next()) {
                    st = new UserInformation();
                    st.setUserId(rs.getInt("UserId"));
                    st.setName(rs.getString("Name"));
                    st.setEmail(rs.getString("Email"));
                    st.setPassword(rs.getString("Password"));
                    st.setRole(rs.getInt("Role"));
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

    public List<UserInformation> getUserInformation() {
        List<UserInformation> UserInformation = new ArrayList<>();
         try {
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                    Statement stmt = conn.createStatement(); 
                    ResultSet rs = stmt.executeQuery("SELECT * FROM UserInformation");) {
                while (rs.next()) {
                    UserInformation st = new UserInformation();
                    st.setUserId(rs.getInt("UserId"));
                    st.setName(rs.getString("Name"));
                    st.setEmail(rs.getString("Email"));
                    st.setPassword(rs.getString("Password"));
                    st.setRoleId(rs.getInt("RoleId"));
                    UserInformation.add(st);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {

        }

     return UserInformation;
    }
    
    public boolean addUserInformation(UserInformation st) {
        try {
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                    Statement stmt = conn.createStatement(); 
                    ) {
                stmt.executeUpdate("INSERT INTO UserInformation (UserId, Name, Email, Password, RoleId) "
                        + "VALUES ('"+ st.getUserId()+"','"+ st.getName()+"','"+ st.getEmail()+"','"+ st.getPassword()+"', '"+ st.getRoleId()+"');");
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {

        }
        return false;
    }

    public boolean updateUserInformation(UserInformation st) {
        try {
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                    Statement stmt = conn.createStatement(); 
                    ) {
                stmt.executeUpdate("UPDATE UserInformation SET UserId = '" +st.getUserId()+ "',Name = '" +st.getName()+ "', Email = '" + st.getEmail()+ "',  Password = '" + st.getPassword()+ "', RoleId = '" + st.getRoleId()+ "' WHERE (Id = '" + st.getUserId()+"');");
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {

        }
        return false;
    }
    

}
