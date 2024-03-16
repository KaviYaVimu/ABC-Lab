/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author kavin
 */
public class Appointment {
    
    private int id;
    private String Name;
    private String PhoneNumber;
    private String ReportType;
    private String Gender;
    private String Email;
    private String AppointmentTime;
    private String AppointmentDate;
    private int UserId;
    
    public Appointment(){
        
    }

    public Appointment(int id, String Name, String PhoneNumber, String ReportType, String Gender, String Email, String AppointmentTime, String AppointmentDate, int UserId) {
        this.id = id;
        this.Name = Name;
        this.PhoneNumber = PhoneNumber;
        this.ReportType = ReportType;
        this.Gender = Gender;
        this.Email = Email;
        this.AppointmentTime = AppointmentTime;
        this.AppointmentDate = AppointmentDate;
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

    public String getReportType() {
        return ReportType;
    }

    public void setReportType(String ReportType) {
        this.ReportType = ReportType;
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

    public String getAppointmentTime() {
        return AppointmentTime;
    }

    public void setAppointmentTime(String AppointmentTime) {
        this.AppointmentTime = AppointmentTime;
    }

    public String getAppointmentDate() {
        return AppointmentDate;
    }

    public void setAppointmentDate(String AppointmentDate) {
        this.AppointmentDate = AppointmentDate;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }
    
}
