/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author kavin
 */
public class Prescription {
    
    private int Presid;
    private String Results;
    private String Document;
    private int UserId;
    
    public Prescription(){
        
        
        
    }

    public Prescription(int Presid, String Results, String Document, int UserId) {
        this.Presid = Presid;
        this.Results = Results;
        this.Document = Document;
        this.UserId = UserId;
    }

    public int getPresid() {
        return Presid;
    }

    public void setPresid(int Presid) {
        this.Presid = Presid;
    }

    public String getResults() {
        return Results;
    }

    public void setResults(String Results) {
        this.Results = Results;
    }

    public String getDocument() {
        return Document;
    }

    public void setDocument(String Document) {
        this.Document = Document;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

   
}
