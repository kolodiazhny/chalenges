package com.kolodiazhny.resource;

import com.kolodiazhny.entity.NameEntity;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/service/1")
public interface NameResource {
    @GET
    @Path("/name")
    @Produces({MediaType.APPLICATION_JSON})
    NameEntity getName();

    @POST
    @Path("/name")
    @Consumes("application/json")
    @Produces("application/json")
    String setName();
}