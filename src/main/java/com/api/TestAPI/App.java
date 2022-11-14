package com.api.TestAPI;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
         String inputLine = "";
		JSONParser parser = new JSONParser();
		JSONArray array = new JSONArray();
		try {
			String apiUrl = "https://jsonplaceholder.typicode.com/users";
			URL url = new URL(apiUrl);
			HttpURLConnection hrConnection = (HttpURLConnection) url.openConnection();

			System.out.println(hrConnection.getResponseCode());
			BufferedReader bReader = new BufferedReader(new InputStreamReader(hrConnection.getInputStream()));
			StringBuffer bfBuffer = new StringBuffer();
			while ((inputLine=bReader.readLine())!=null) {
				bfBuffer.append(inputLine);
				
			}
			bReader.close();
			bfBuffer.toString();
			System.out.println(bfBuffer.toString());
			JSONObject jsonObject = new JSONObject();
			String jsonString = jsonObject.toJSONString();
		}
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
