package com.harsh.salesforce;

import java.io.IOException;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.util.EntityUtils;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.JSONException;

public class Main {

	    static final String USERNAME     = "sweety.shah@spec-india.com.finaid";
	    static final String PASSWORD     = "Trinity!1233m0fVY98Y8obXve7fOpcRluMm";
	    static final String LOGINURL     = "https://test.salesforce.com";
	    static final String GRANTSERVICE = "/services/oauth2/token?grant_type=password";
	    static final String CLIENTID     = "3MVG9ifmAKCHISbZZLjtLJyEvMFeO5xtbKXfwJcTXqy3prF14JqsgCBslE2JgIBGqVltrW9LnZ1zlDyEVPGod";
	    static final String CLIENTSECRET = "2918011653192313675";

	public static void main(String ar[]){
	
		        HttpClient httpclient = HttpClientBuilder.create().build();
		 
		        // Assemble the login request URL
		        String loginURL = LOGINURL +
		                          GRANTSERVICE +
		                          "&client_id=" + CLIENTID +
		                          "&client_secret=" + CLIENTSECRET +
		                          "&username=" + USERNAME +
		                          "&password=" + PASSWORD;
		        System.out.println(loginURL);
		        // Login requests must be POSTs
		        HttpPost httpPost = new HttpPost(loginURL);
		        HttpResponse response = null;
		 
		        try {
		            // Execute the login POST request
		            response = httpclient.execute(httpPost);
		        } catch (ClientProtocolException cpException) {
		            cpException.printStackTrace();
		        } catch (IOException ioException) {
		            ioException.printStackTrace();
		        }
		 
		        // verify response is HTTP OK
		        final int statusCode = response.getStatusLine().getStatusCode();
		        if (statusCode != HttpStatus.SC_OK) {
		            System.out.println("Error authenticating to Force.com: "+statusCode);
		            // Error is in EntityUtils.toString(response.getEntity())
		            return;
		        }
		 
		        String getResult = null;
		        try {
		            getResult = EntityUtils.toString(response.getEntity());
		        } catch (IOException ioException) {
		            ioException.printStackTrace();
		        }
		        JSONObject jsonObject = null;
		        String loginAccessToken = null;
		        String loginInstanceUrl = null;
		        String loginTokenType = null;
		        try {
		            jsonObject = (JSONObject) new JSONTokener(getResult).nextValue();
		            loginAccessToken = jsonObject.getString("access_token");
		            loginInstanceUrl = jsonObject.getString("instance_url");
		            loginTokenType = jsonObject.getString("token_type");
		        } catch (JSONException jsonException) {
		            jsonException.printStackTrace();
		        }
		        System.out.println(response.getStatusLine());
		        System.out.println("Successful login");
		        System.out.println("  instance URL: "+loginInstanceUrl);
		        System.out.println("  access token : "+loginAccessToken);
		        System.out.println("  Token Type :"+loginTokenType);
		 
		        // release connection
		        httpPost.releaseConnection();
		    }
}
