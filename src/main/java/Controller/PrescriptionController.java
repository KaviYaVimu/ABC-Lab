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
import Access.PrescriptionAccess;
import Model.Prescription;

/**
 *
 * @author kavin
 */
@Path("Prescription")
public class PrescriptionController {
    Gson gson = new Gson();

    public PrescriptionController() {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudents(){ 
        
        
        return Response
                .ok(gson.toJson(new PrescriptionAccess().getPrescription()))
                .build();
    }
    
    @GET
    @Path("{Presid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudent(@PathParam("Presid") int Presid){ 
        try {
        Prescription student = new PrescriptionAccess().getPrescription(Presid);
        
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
        Prescription Prescription = gson.fromJson(json, Prescription.class); 
        new PrescriptionAccess().addPrescription(Prescription);
        return Response
                .status(Response.Status.CREATED)
                .build();
    }
    
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateStudent(String json, @PathParam("Presid") int Presid){ 
        Prescription Prescription = gson.fromJson(json, Prescription.class);
        new PrescriptionAccess().updatePrescription(Prescription);
        return Response
                    .ok()
                    .build();
    }
    
    
   }
