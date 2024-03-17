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
import Model.Admin;

/**
 *
 * @author kavin
 */
public class AdminAccess {
    
      static final String DB_URL = "jdbc:mysql://localhost:3306/abc_lab";
    static final String USER = "root";
    static final String PASS = "";
    
    
        public AdminAccess() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            
        }
    }

        public Admin getAdmin(int Aid) throws SQLException {
        Admin st = null;
         try {

            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                    Statement stmt = conn.createStatement(); 
                    ResultSet rs = stmt.executeQuery("SELECT * FROM Admin WHERE Id="+ Aid);) {
                while (rs.next()) {
                    st = new Admin();
                    st.setAid(rs.getInt("AId"));
                    st.setName(rs.getString("Name"));
                    st.setEmail(rs.getString("email"));
                    st.setUserId(rs.getInt("userId"));
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

        
        public List<Admin> getAdmin() {
        List<Admin> Admin = new ArrayList<>();
         try {
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                    Statement stmt = conn.createStatement(); 
                    ResultSet rs = stmt.executeQuery("SELECT * FROM Admin");) {
                while (rs.next()) {
                    Admin st = new Admin();
                    st.setAid(rs.getInt("AId"));
                    st.setName(rs.getString("Name"));
                    st.setEmail(rs.getString("email"));
                    st.setUserId(rs.getInt("userId"));
                    Admin.add(st);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {

        }

        return Admin;
    }
}