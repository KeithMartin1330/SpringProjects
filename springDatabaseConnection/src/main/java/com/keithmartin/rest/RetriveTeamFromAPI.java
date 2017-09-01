package com.keithmartin.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import com.keithmartin.Model.Player;

import org.json.JSONArray;
import org.json.JSONObject;

public class RetriveTeamFromAPI {
	public ArrayList<Player> getLatestSquad() throws IOException {
		String url = "http://api.football-data.org/v1/teams/66/players";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", "en-US,en;q=0.5");

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		JSONObject jsonObject = new JSONObject(response.toString());		 
		JSONArray tsmresponse = (JSONArray) jsonObject.get("players");

		ArrayList<Player> list = new ArrayList<Player>();
		Player playerTemplate =null;

		for(int i=0; i<tsmresponse.length(); i++){
			String name=tsmresponse.getJSONObject(i).getString("name");

			String dob = tsmresponse.getJSONObject(i).getString("dateOfBirth");
			String position =tsmresponse.getJSONObject(i).getString("position");
			playerTemplate = new Player(name,dob,position);

			list.add(playerTemplate);
		}

		return list;
	}
}
