package com.api.TestAPI;

import java.util.ArrayList;
import java.util.List;
import org.json.*;
import com.google.gson.Gson;

public class JSONArrayDemo
{

	public static void main(String[] args) throws Exception {
		
		Employee employee1 = new Employee(101, "saif", "GZP");
		Employee employee2 = new Employee(102, "samir", "GZP"); 
		List<Employee> list = new ArrayList();
		list.add(employee1);
		list.add(employee2);
		Gson gson = new Gson();
		 String json = gson.toJson(list);
		 System.out.println(json);
		JSONArray jsonarray = new JSONArray(json);
		for (int i = 0; i < jsonarray.length(); i++) {
		    org.json.JSONObject jsonobject = jsonarray.getJSONObject(i);
		    int id = jsonobject.getInt("id");
		    String name = jsonobject.getString("name");
		    String address = jsonobject.getString("address");
		    System.out.println(id);
		    System.out.println(name);
		    System.out.println(address);
		}
		}
		 
	}
