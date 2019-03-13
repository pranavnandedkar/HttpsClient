package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class ApacheHTTPClient {
  public static void main(String[] args) {
    try {
      String url = "https://www.google.com/search?q=httpClient";

      HttpClient client = HttpClientBuilder.create().build();
      HttpGet request = new HttpGet(url);

      // add request header
      //  request.addHeader("User-Agent", USER_AGENT);
      HttpResponse response;
      response = client.execute(request);

      System.out.println("Response Code : " 
          + response.getStatusLine().getStatusCode());

      BufferedReader rd = new BufferedReader(
          new InputStreamReader(response.getEntity().getContent()));

      StringBuffer result = new StringBuffer();
      String line = "";
      while ((line = rd.readLine()) != null) {
        result.append(line);
      }
      System.err.println(result.toString());
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
