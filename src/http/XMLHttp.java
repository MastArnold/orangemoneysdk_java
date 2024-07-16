/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package http;

import Response.XMLResponse;
import java.util.List;
import java.util.HashMap;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.OutputStream;
import java.io.InputStream;
import java.util.Map;

public class XMLHttp {
    public static final boolean WITH_SSL_ENABLED = true;
    public static final boolean WITH_SSL_DISABLED = false;

    public static Map<String, Object> request(String url, List<String> headers, String body, boolean withSSLEnabled) throws Exception {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
       
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        for (String header : headers) {
            connection.setRequestProperty(header.split(":")[0], header.split(":")[1]);
        }
        
        //connection.setSSLSocketFactory(withSSLEnabled ? (SSLSocketFactory) SSLSocketFactory.getDefault() : null);

        try (OutputStream os = connection.getOutputStream()) {
            os.write(body.getBytes(), 0, body.length());
        }

        int responseCode = connection.getResponseCode();
        StringBuilder response = new StringBuilder();
        try (InputStream is = connection.getInputStream()) {
            int read;
            while ((read = is.read()) != -1) {
                response.append((char) read);
            }
        }
        
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("errno", responseCode);
        responseMap.put("error", responseCode == 200 ? "" : "Error occurred");
        responseMap.put("response", XMLResponse.parse("<response>" + response.toString() + "</response>"));
        
        return responseMap;
    }
}
