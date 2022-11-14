package com.api.TestAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class ReadJSONFromURL {

	public static void main(String[] args) {
		String s1 = "";
		StringBuffer buffer = new StringBuffer();
		try {
			String jsonUrl = "https://jsonplaceholder.typicode.com/posts";
			URL url = new URL(jsonUrl);
			HttpURLConnection openConnection = (HttpURLConnection) url.openConnection();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openConnection.getInputStream()));
 
			while ((s1 = bufferedReader.readLine()) != null) {
				buffer.append(s1);
			}

			String string = buffer.toString();
			JSONArray jsonarray = new JSONArray(string);

			for (int i = 0; i < jsonarray.length(); i++) {

				JSONObject jsonobject = jsonarray.getJSONObject(i);
				int userId = jsonobject.getInt("userId");
				int Id = jsonobject.getInt("id");
				String title = jsonobject.getString("title");
				String body = jsonobject.getString("body");
				System.out.println("--------------------");
				System.out.println("UserID : " + userId);
				System.out.println("ID : " + Id);
				System.out.println("Title : " + title);
				System.out.println("Body : " + body);
			}
			bufferedReader.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
