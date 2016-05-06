package com.kolodiazhny;


public class TransferWiseClient implements com.kolodiazhny.Client {

    private static final String INDIVIDUAL_TOKEN = "6ee5d540d9855947dee6040451089dd1c783f97b";
    private static final String DESTINATION_URL = "http://bootcamp-api.transferwise.com";
    private static final String TASK_PREFIX = "/service";


    @Override
    public String getMainScreen() {
        return get("");
    }

    @Override
    public String getTaskInfo(int taskId) {
        return get(TASK_PREFIX + "/" + taskId);
    }

    @Override
    public String getCurrentTaskInfo() {
        return get(TASK_PREFIX);
    }

    @Override
    public void startTask(int taskId) {

    }

    private String get(String path) {
        String output = "";
       /* try {
            ClientConfig clientConfig = new DefaultClientConfig();
            clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
            Client client = Client.create(clientConfig);

            WebResource webResourceGet = client.resource(DESTINATION_URL + path).queryParam("token", INDIVIDUAL_TOKEN);
            ClientResponse response = webResourceGet.get(ClientResponse.class);

            if (response.getStatus() != 200) {
                throw new WebApplicationException(response.getStatus());
            }
            output = response.getEntity(String.class);
        } catch (Exception e) {
            output = "Internal exception: " + e.getMessage();
        } */
        return output;
    }


}
