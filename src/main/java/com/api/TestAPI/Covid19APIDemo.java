package com.api.TestAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class Covid19APIDemo {

	public static void main(String[] args) {

		String s1 = "";
		StringBuffer buffer = new StringBuffer();
		Scanner in = new Scanner(System.in);
		System.out.print("Enter Country name: ");
		String country = in.nextLine();
		String covid_API_URL = "https://api.covid19api.com/";
		String covid_API_Countries_URL = "total/dayone/country/"+country;
		try {
			URL url = new URL(covid_API_URL + covid_API_Countries_URL);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while ((s1 = bufferedReader.readLine()) != null) {
				buffer.append(s1);
			}
			String string = buffer.toString();
			//System.out.println(string);

			JSONArray jsonArray = new JSONArray(string);
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				String Country = (String) jsonObject.get("Country");
				int Confirmed =   jsonObject.getInt("Confirmed");
				int Active = jsonObject.getInt("Active");
				String Date = (String) jsonObject.get("Date");
				System.out.println(Country);
				System.out.println(Confirmed);
				System.out.println(Active);
				System.out.println(Date);
			}

			/*
			 * JSONObject jsonObject = new JSONObject(string); JSONObject countriesRoute_VAR
			 * =(JSONObject)jsonObject.get("countriesRoute"); String countriesRoute_Name =
			 * (String) countriesRoute_VAR.get("Name"); String countriesRoute_Description =
			 * (String) countriesRoute_VAR.get("Description"); String countriesRoute_Path =
			 * (String) countriesRoute_VAR.get("Path");
			 * 
			 * 
			 * JSONObject countryDayOneRoute_VAR
			 * =(JSONObject)jsonObject.get("countryDayOneRoute"); String
			 * countryDayOneRoute_Name = (String) countryDayOneRoute_VAR.get("Name"); String
			 * countryDayOneRoute_Description = (String)
			 * countryDayOneRoute_VAR.get("Description"); String countryDayOneRoute_Path =
			 * (String) countryDayOneRoute_VAR.get("Path");
			 */

			/*
			 * System.out.println("***************countriesRoute*******************");
			 * System.out.println(countriesRoute_Name);
			 * System.out.println(countriesRoute_Description);
			 * System.out.println(countriesRoute_Path);
			 * 
			 * System.out.println("***************countryDayOneRoute*******************");
			 * System.out.println(countryDayOneRoute_Name);
			 * System.out.println(countryDayOneRoute_Description);
			 * System.out.println(countryDayOneRoute_Path);
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
