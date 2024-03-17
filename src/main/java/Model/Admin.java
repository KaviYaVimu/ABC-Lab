/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author kavin
 */
public class Admin {
    
    private int Aid;
    private String Name;
    private String Email;
    private int UserId;
    
    public Admin(){
        
    }

    public Admin(int Aid, String Name, String Email, int UserId) {
        this.Aid = Aid;
        this.Name = Name;
        this.Email = Email;
        this.UserId = UserId;
    }

    public int getAid() {
        return Aid;
    }

    public void setAid(int Aid) {
        this.Aid = Aid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }
    

}