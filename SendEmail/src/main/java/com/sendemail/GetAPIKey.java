package com.sendemail;

import java.io.IOException;


import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

public class GetAPIKey {
    public static void main(String[] args) throws IOException {
        try {
            SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
            sg.addRequestHeader("on-behalf-of", "The subuser's username. This header generates the API call as if the subuser account was making the call.");
            Request request = new Request();
            request.setMethod(Method.GET);
            request.setEndpoint("/api_keys/887zcMvMWLytkytW");
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) { throw ex; }
    }
}
