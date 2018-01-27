package com.consumer.tests;

import com.google.gson.Gson;
import com.pact.poc.User;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;

import java.io.IOException;

/**
 * Created by Yuvaraj on 26/01/2018.
 */
public class ServiceConsumerClient  {
    private String baseUri;

    public ServiceConsumerClient(String baseUri) {
        this.baseUri = baseUri;
    }

    public Response getUserInformation() {
        Response response = null;
        try {
            response = Request.Get(baseUri+"/pact/user")
                    .execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
