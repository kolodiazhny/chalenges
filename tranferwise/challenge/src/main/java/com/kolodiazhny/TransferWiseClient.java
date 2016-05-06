package com.kolodiazhny;


import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class TransferWiseClient implements Clientable {

    private static final String INDIVIDUAL_TOKEN = "6ee5d540d9855947dee6040451089dd1c783f97b";
    private static final String REST_SERVICE_URL = "http://bootcamp-api.transferwise.com";
    private static final String TASK_PREFIX = "/task";
    public static final String START_COMMAND = "start";
    public static final String FINISH_COMMAND = "finish";
    public static final String SLASH = "/";
    public static final int TASK1 = 1;
    public static final int TASK2 = 2;
    public static final String MY_NAME = "Oleksandr Kolodiazhnyi";
    public static final String TASK1_PARAMETER = "/name";
    public static final String TASK2_PARAMETER = "/survivor";


    @Override
    public String getMainScreen() {
        return get("");
    }

    @Override
    public String getTaskInfo(int taskId) {
        return get(TASK_PREFIX + SLASH + taskId);
    }

    @Override
    public String getCurrentTaskInfo() {
        return get(TASK_PREFIX);
    }

    @Override
    public String startTask(int taskId) {
        return post(TASK_PREFIX + SLASH + taskId + SLASH + START_COMMAND);

    }

    @Override
    public String resolveTask(int taskId) {
        StringBuilder result = new StringBuilder();
        if (taskId == TASK1) {
            result.append(post(TASK1_PARAMETER + SLASH + MY_NAME));
            result.append(get(TASK1_PARAMETER));
        } else if (taskId == TASK2) {
            result.append(post(TASK2_PARAMETER + SLASH + new Task2().getResult()));
        }
        return result.toString();
    }

    @Override
    public String finishCurrentTask() {
        return post(TASK_PREFIX + SLASH + FINISH_COMMAND);
    }

    private String get(String path) {
        String output;

        try {
            Client client = ClientBuilder.newClient(new ClientConfig().register(LoggingFilter.class));
            WebTarget webTarget = client.target(REST_SERVICE_URL).path(path).queryParam("token", INDIVIDUAL_TOKEN);
            Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
            Response response = invocationBuilder.get();
            if (response.getStatus() != 200) {
                throw new WebApplicationException(response.getStatus());
            }
            output = response.readEntity(String.class);
        } catch (Exception e) {
            output = "Internal exception: " + e.getMessage();
            e.printStackTrace();
        }
        return output;
    }

    private String post(String path) {
        String output;
        try {
            Client client = ClientBuilder.newClient(new ClientConfig().register(LoggingFilter.class));
            WebTarget webTarget = client.target(REST_SERVICE_URL).path(path).queryParam("token", INDIVIDUAL_TOKEN);
            Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
            Response response = invocationBuilder.post(Entity.entity(path, MediaType.TEXT_PLAIN));
            if (response.getStatus() != 200) {
                throw new WebApplicationException(response.getStatus());
            }
            output = response.readEntity(String.class);

        } catch(Exception e) {
            output = "Internal exception: " + e.getMessage();
        }
        return output;
    }

}
