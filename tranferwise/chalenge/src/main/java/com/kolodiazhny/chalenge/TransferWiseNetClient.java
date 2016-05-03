package com.kolodiazhny.chalenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TransferWiseNetClient implements Callable {

    private static final String MY_TOKEN = "?token=6ee5d540d9855947dee6040451089dd1c783f97b";
    private static final String DESTINATION_URL = "http://bootcamp-api.transferwise.com/task/";

    @Override
    public String getTaskInfo(int taskId) {
        String result = "";
        try {
            URL url = new URL(DESTINATION_URL + taskId + MY_TOKEN);
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

}
