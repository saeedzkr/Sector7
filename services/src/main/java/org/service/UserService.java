package org.service;


import org.entity.Credit;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/UserService")
public class UserService {


    @GET
    @Path("/users")
    public String getUsers(@QueryParam("username") String user) {
        return "hello " + user;
    }


    @GET
    @Path("/credit")
    @Produces(MediaType.APPLICATION_JSON)
    public Response responseCredit(@QueryParam("username") String user ,@QueryParam("password") String password) {
        String output = "Prameter1: " + user + "\nParameter2: " + password;
        return Response.status(200).entity(output).build();
    }
        //todo ok
    @GET
    @Path("/remain")
    @Produces(MediaType.APPLICATION_JSON)
    public org.entity.Credit remain(@QueryParam("username") String user ,@QueryParam("password") String password)
    {
        Credit credit = new Credit("saeed" , "fatoldsun" , 100 );
//        String output = "Prameter1: " + user + "\nParameter2: " + password;
//        return Response.status(200).entity(output).build();

        return credit;
    }

}