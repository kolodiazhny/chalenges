package com.kolodiazhny.chalenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TransferWiseNetClient implements Callable {

    public static final int CURRENT_TASK_ID = 0;
    private static final String INDIVIDUAL_TOKEN = "?token=6ee5d540d9855947dee6040451089dd1c783f97b";
    private static final String DESTINATION_URL = "http://bootcamp-api.transferwise.com/task/";

    //http://www.mkyong.com/webservices/jax-rs/restful-java-client-with-jersey-client/
    @Override
    public String getTaskInfo(int taskId) {
        String result = "";
        try {
            URL url = getUrlByTaskId(taskId);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output;
            while ((output = br.readLine()) != null) {
                result += output;
            }
            conn.disconnect();

        } catch (MalformedURLException e) {
            return "Malformed error:";
        } catch (IOException e) {
            return "Server error: ";
        }
        return result;
    }

    private URL getUrlByTaskId(int taskId) throws MalformedURLException {
        if (taskId == CURRENT_TASK_ID) {
            return new URL(DESTINATION_URL + INDIVIDUAL_TOKEN);
        }
        return new URL(DESTINATION_URL + taskId + INDIVIDUAL_TOKEN);
    }

    @Override
    public String getCurrentTaskInfo() {
        return getTaskInfo(CURRENT_TASK_ID);
    }

    @Override
    public void startTask(int taskId) {

    }

}
