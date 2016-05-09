package com.kolodiazhny.service;

import com.kolodiazhny.client.TransferWiseClient;
import com.kolodiazhny.dao.impl.ResultDaoJsonImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/task")
public class TransferWiseService {

    private TransferWiseClient client;
    public TransferWiseService() {
        client = new TransferWiseClient();
    }

//    @GET
//    @Path("/1/{param}")
//    public Response getMsg(@PathParam("param") String msg) {
//        String output = "Jersey say : " + msg;
//        return Response.status(200).entity(output).build();
//    }

    @GET
    @Path("/1")
    @Produces(MediaType.TEXT_PLAIN)
    public String getTaskResult1() {
        return getTaskResult(1);
    }

    @GET
    @Path("/2")
    @Produces(MediaType.TEXT_PLAIN)
    public String getTaskResult2() {
        return getTaskResult(2);
    }

    @GET
    @Path("/3")
    @Produces(MediaType.TEXT_PLAIN)
    public String getTaskResult3() {
        return getTaskResult(3);
    }


    private String getTaskResult(int taskId) {
        client.startTask(taskId);
        client.resolveTask(taskId);
        String json = client.finishCurrentTask();
        return new ResultDaoJsonImpl().getResult(json);

    }

}

