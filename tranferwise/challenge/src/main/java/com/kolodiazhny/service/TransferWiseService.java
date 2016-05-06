package com.kolodiazhny.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/task")
public class TransferWiseService {

    @GET
    public String getMsg() {
        return "Jersey works";
    }
    /*@GET
    @Path("/{param}")
    public Response getMsg(@PathParam("param") String msg) {

        String output = "Jersey say : " + msg;

        return Response.status(200).entity(output).build();

    }*/

}

