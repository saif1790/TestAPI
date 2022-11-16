package com.api.TestAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

/*
https://codebeautify.org/jsonviewer
*/
public class ReadJSONObject {

	private static final String JSONObject = null;

	public static void main(String[] args) {

		String jsonObjectURL = "https://dummyjson.com/products";
		String s1 = "";
		StringBuffer buffer = new StringBuffer();
		try {
			URL url = new URL(jsonObjectURL);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while ((s1 = bufferedReader.readLine()) != null) {
				buffer.append(s1);
			}
			String string = buffer.toString();

			JSONObject jsonObject = new JSONObject(string);

			int total = (int) jsonObject.get("total");
			int skip = (int) jsonObject.get("skip");
			int limit = (int) jsonObject.get("limit");

			System.out.println("******************************");

			JSONArray jsonarray = (JSONArray) jsonObject.get("products");

			System.out.println(jsonarray.length());
			for (int i = 0; i < jsonarray.length(); i++) {
				System.out.println("----");
				JSONObject jsonObject2 = (JSONObject) jsonarray.getJSONObject(i);
				int id = (int) jsonObject2.get("id");
				String title = (String) jsonObject2.get("title");
				String description = (String) jsonObject2.get("description");
				int price = jsonObject2.getInt("price");
				float disPercentage = jsonObject2.getFloat("discountPercentage");
				float rating = jsonObject2.getFloat("rating");
				int stock = jsonObject2.getInt("stock");
				String brand = (String) jsonObject2.get("brand");
				String category = (String) jsonObject2.get("category");
				String thumbnail = (String) jsonObject2.get("thumbnail");

				System.out.println("ID : " + id);
				System.out.println("Title : " + title);
				System.out.println("Description : " + description);
				System.out.println("Price : " + price);
				System.out.println("Discounted Percentage : " + disPercentage);
				System.out.println("Rating : " + rating);
				System.out.println("Stock : " + stock);
				System.out.println("Brand : " + brand);
				System.out.println("Category: " + category);
				System.out.println("Thumbnail : " + thumbnail);

				JSONArray images = (JSONArray) jsonObject2.get("images");
			
				for (int j = 0; j < images.length(); j++) {
					System.out.println("Images : " + images.getString(j));
				}
			}

			System.out.println("Total : " + total);
			System.out.println("Skip : " + skip);
			System.out.println("Limit : " + limit);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
