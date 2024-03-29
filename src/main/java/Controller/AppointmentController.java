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
import Access.AppointmentAccess;
import Model.Appointment;

/**
 *
 * @author kavin
 */
@Path("Appointment")
public class AppointmentController {
    Gson gson = new Gson();

    public AppointmentController() {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudents(){ 
        
        
        return Response
                .ok(gson.toJson(new AppointmentAccess().getAppointment()))
                .build();
    }
    
    @GET
    @Path("{APid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudent(@PathParam("APid") int APid){ 
        try {
        Appointment student = new AppointmentAccess().getAppointment(APid);
        
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
        Appointment Appointment = gson.fromJson(json, Appointment.class); 
        new AppointmentAccess().addAppointment(Appointment);
        return Response
                .status(Response.Status.CREATED)
                .build();
    }
    
    @PUT
    @Path("{APid}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateStudent(String json, @PathParam("APid") int APid){ 
        Appointment Appointment = gson.fromJson(json, Appointment.class);
        new AppointmentAccess().updateAppointment(Appointment);
        return Response
                    .ok()
                    .build();
    }
    
    
   
}
