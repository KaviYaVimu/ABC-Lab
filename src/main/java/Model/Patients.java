/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author kavin
 */
public class Patients {
    
    private int id;
    private String Name;
    private String PhoneNumber;
    private String DOB;
    private String Gender;
    private String Email;
    private int UserId;
    
    public Patients(){
        
    }
    


    public Patients(int id, String Name, String PhoneNumber, String DOB, String Gender, String Email, int UserId) {
        this.id = id;
        this.Name = Name;
        this.PhoneNumber = PhoneNumber;
        this.DOB = DOB;
        this.Gender = Gender;
        this.Email = Email;
        this.UserId = UserId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
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
    

