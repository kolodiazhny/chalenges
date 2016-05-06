package com.kolodiazhny.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/task")
public class TransferWiseService {

    @GET
    @Path("/1/{param}")
    public Response getMsg(@PathParam("param") String msg) {
        String output = "Jersey say : " + msg;
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/1")
    public String getMsg2() {
        return "Jersey works";
    }

}

