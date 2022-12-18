package com.interview_test.test;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.interview_test.main.Json_Objects;

public class Interview_Test_Scenarious extends Json_Objects {

	@Test
	public void validate_Four_Foreign_payers_In_the_team() {
		int expectedNumberOfPlayersOutsideIndia = 4;
		int actualNumberOfPlayersOutSideIndia = 0;

		JSONObject bangaloreTeam = bangaloreTeamJson();

		JSONArray bangaloreTeamPalyers = bangaloreTeam.getJSONArray("player");

		for (int i = 0; i < bangaloreTeamPalyers.length(); i++) {
			JSONObject jObj = bangaloreTeamPalyers.getJSONObject(i);

			String playerCountry = jObj.getString("country");

			System.out.println(playerCountry);

			if (!playerCountry.contains("India")) {
				actualNumberOfPlayersOutSideIndia++;
			}

		}

		System.out.println("Total number of players Out Side india found :" + actualNumberOfPlayersOutSideIndia);

		Assert.assertEquals(actualNumberOfPlayersOutSideIndia, expectedNumberOfPlayersOutsideIndia);

	}

	@Test
	public void validate_at_least_one_wicket_keeper_present_in_the_team() {
		int expectedNumberOfWicketKeepers = 1;
		int actualNumberOfWicketKeepers = 0;

		JSONObject bangaloreTeam = bangaloreTeamJson();

		JSONArray bangaloreTeamPalyers = bangaloreTeam.getJSONArray("player");

		for (int i = 0; i < bangaloreTeamPalyers.length(); i++) {
			JSONObject jObj = bangaloreTeamPalyers.getJSONObject(i);

			String playerRole = jObj.getString("role");

			System.out.println(playerRole);

			if (playerRole.contains("Wicket-keeper")) {
				actualNumberOfWicketKeepers++;
			}

		}

		System.out.println("Total number of WicketKeepers found :" + actualNumberOfWicketKeepers);

		Assert.assertTrue(actualNumberOfWicketKeepers>=expectedNumberOfWicketKeepers,"Actual wicket keepers count : "+actualNumberOfWicketKeepers+ "is less than expected number of wicket keepers "+expectedNumberOfWicketKeepers);

	}

}
