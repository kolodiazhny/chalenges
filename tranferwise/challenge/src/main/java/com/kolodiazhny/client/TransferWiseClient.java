package com.kolodiazhny.client;


import com.kolodiazhny.dao.AccountDao;
import com.kolodiazhny.dao.impl.AccountDaoJsonImpl;
import com.kolodiazhny.model.Account;
import com.kolodiazhny.tasks.Task1;
import com.kolodiazhny.tasks.Task2;
import com.kolodiazhny.tasks.Task3;
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
    public static final String GET_ALL_BANKS ="/bank";
    private static final String GET_BANK_ACCOUNT ="/bankAccount" ;
    public static final String SLASH = "/";
    public static final int TASK1 = 1;
    public static final int TASK2 = 2;
    private static final int TASK3 = 3;

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
            Task1 task = new Task1();
            result.append(post(task.getParameter() + SLASH + task.getName()));
            result.append(get(task.getParameter()));
        } else if (taskId == TASK2) {
            Task2 task = new Task2();
            result.append(post(task.getParameter() + SLASH + new Task2().getResult()));
        } else if (taskId == TASK3) {
            Task3 task = new Task3();
            result.append(task.transfer());
        }
        return result.toString();
    }

    public String getInfo() {
        StringBuilder result = new StringBuilder();
//        result.append(get(GET_ALL_BANKS));
        result.append(get(GET_BANK_ACCOUNT));
        AccountDao accountDao = new AccountDaoJsonImpl(result.toString());
        Account account = accountDao.findById("5730e354e4b03f261fb2177d");
        return account.getAccountName();
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

        } catch (Exception e) {
            output = "Internal exception: " + e.getMessage();
        }
        return output;
    }

}
