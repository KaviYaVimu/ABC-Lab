/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import com.google.gson.Gson;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.sql.SQLException;
import Access.PatientsAccess;
import Model.Patients;

/**
 *
 * @author kavin
 */
@Path("Patient")
public class PatientsController {
    Gson gson = new Gson();

    public PatientsController() {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudents(){ 
        
        
        return Response
                .ok(gson.toJson(new PatientsAccess().getPatients()))
                .build();
    }
    
    @GET
    @Path("{Pid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudent(@PathParam("Pid") int Pid){ 
        try {
        Patients student = new PatientsAccess().getPatients(Pid);
        
        if (student != null) {
                  return Response
                    .ok(gson.toJson(student))
                    .build();
        } 

        return Response
                .status(Response.Status.NOT_FOUND)
                .build();
        } catch(SQLException e) {
             return Response
                .status(Response.Status.INTERNAL_SERVER_ERROR)
                .build();
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addStudent(String json){ 
        Patients Patient = gson.fromJson(json, Patients.class); 
        new PatientsAccess().addPatient(Patient);
        return Response
                .status(Response.Status.CREATED)
                .build();
    }
    
    @PUT
    @Path("{Pid}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateStudent(String json, @PathParam("Pid") int Pid){ 
        Patients student = gson.fromJson(json, Patients.class);
        new PatientsAccess().updatePatient(student);
        return Response
                    .ok()
                    .build();
    }
    
    
  
}
