package personalcapital;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TestSearch {
public static JSONObject getJson() {
	String url="https://search-pcsharat-sdtgdrvrt2qxhosz5j6iht2atu.us-east-1.es.amazonaws.com/plans/_search?q=";
	
		try {
			url+="PLAN_NAME:\""+URLEncoder.encode("ENCOMPASS HOME HEALTH 401(K) SAVINGS PLAN", "UTF-8")+"\"";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}						
	
	
	
	
	StringBuffer response = new StringBuffer(); 
	JSONObject json = null;
	try {
		URL obj= new URL(url);
		System.out.println(url);
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
  public static void main(String[] args) {
	  
	  System.out.println(getJson());
	  
  }
}
