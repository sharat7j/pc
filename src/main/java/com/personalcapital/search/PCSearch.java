package com.personalcapital.search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;									
import java.net.URLEncoder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler; 

class Request{
	String planName;
	String sponsorName;
	String sponsorState;
	
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getSponsorName() {
		return sponsorName;
	}
	public void setSponsorName(String sponsorName) {
		this.sponsorName = sponsorName;
	}
	public String getSponsorState() {
		return sponsorState;
	}
	public void setSponsorState(String sponsorState) {
		this.sponsorState = sponsorState;
	}
	
	public Request(String planName, String sponsorName, String sponsorState){
		this.planName = planName;
		this.sponsorName = sponsorName;
		this.sponsorState = sponsorState;
	}
	
	public Request(){}
	
}

public class PCSearch implements RequestHandler<Request, JSONObject>  {
	public JSONObject handleRequest(Request request, Context context) {
		
		String url="https://search-pcsharat-sdtgdrvrt2qxhosz5j6iht2atu.us-east-1.es.amazonaws.com/plans/_search?q=";
		if(request.planName!=null){
			try {
				url+="PLAN_NAME:\""+URLEncoder.encode("ENCOMPASS HOME HEALTH 401(K) SAVINGS PLAN", "UTF-8")+"\"";
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}						
		}
		
		if(request.sponsorName!=null){
			try {
				url+="SPONSOR_DFE_NAME:\""+URLEncoder.encode("", "UTF-8")+"\"";
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
				}
		if(request.sponsorState!=null){
			try {
				url+="SPONS_DFE_MAIL_US_STATE:\""+URLEncoder.encode("", "UTF-8")+"\"";
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		StringBuffer response = new StringBuffer(); 
		JSONObject json = null;
		try {
			URL obj= new URL(url);
			
			HttpURLConnection con= (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			while((inputLine = in.readLine()) != null){
				response.append(inputLine);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		JSONParser parser = new JSONParser();
		
		try {
			json = (JSONObject) parser.parse(response.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return json;
		}


}
