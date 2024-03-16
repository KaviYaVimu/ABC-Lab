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
import Access.TechniciansAccess;
import Model.Technicians;

/**
 *
 * @author kavin
 */
@Path("technician")
public class TechniciansController {
    Gson gson = new Gson();

    public TechniciansController() {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudents(){ 
        
        
        return Response
                .ok(gson.toJson(new TechniciansAccess().getTechnicians()))
                .build();
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudent(@PathParam("id") int id){ 
        try {
        Technicians student = new TechniciansAccess().getTechnician(id);
        
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
        Technicians Technician = gson.fromJson(json, Technicians.class); 
        new TechniciansAccess().addTechnician(Technician);
        return Response
                .status(Response.Status.CREATED)
                .build();
    }
    
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateStudent(String json, @PathParam("id") int id){ 
        Technicians student = gson.fromJson(json, Technicians.class);
        new TechniciansAccess().updateTechnician(student);
        return Response
                    .ok()
                    .build();
    }
    
    
    @DELETE
    @Path("{id}")
    public Response deleteStudent(@PathParam("id") int id){ 
        new TechniciansAccess().deleteTechnician(id);
        return Response
            .ok()
            .build();
    }
}
