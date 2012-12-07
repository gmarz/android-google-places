package org.gmarz.googleplaces;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import org.gmarz.googleplaces.query.Query;
import org.json.JSONException;
import org.json.JSONObject;

public class GooglePlaces {

	private String mApiKey = "";
	private List<String> mSupportedPlaces;
	
	public GooglePlaces(String apiKey) {
		mApiKey = apiKey;
		loadSupportedPlaces();
	}
	
	public PlacesResult getPlaces(Query query) {
		JSONObject response = executeRequest(query.toString());
		PlacesResult result = null;
		
		try {
			result = new PlacesResult(response);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public DetailsResult getPlaceDetails(Query query) {
		JSONObject response = executeRequest(query.toString());
		DetailsResult result = null;
		
		try {
			result = new DetailsResult(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public boolean isSupportedPlace(String placeType) {
		return (mSupportedPlaces.contains(placeType));
	}
	
	private JSONObject executeRequest(String query) {
		query += "key=" + mApiKey;
		
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(query);

		ResponseHandler<String> handler = new BasicResponseHandler();
		JSONObject jsonResponse = null;
		
		try {
			String response = client.execute(request, handler);
			jsonResponse = new JSONObject(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return jsonResponse;
	}

	private void loadSupportedPlaces() {
		mSupportedPlaces = new ArrayList<String>();
		
		mSupportedPlaces.add("accounting");
		mSupportedPlaces.add("airport");
		mSupportedPlaces.add("amusement park");
		mSupportedPlaces.add("aquarium");
		mSupportedPlaces.add("art gallery");
		mSupportedPlaces.add("atm");
		mSupportedPlaces.add("bakery");
		mSupportedPlaces.add("bank");
		mSupportedPlaces.add("bar");
		mSupportedPlaces.add("beauty salon");
		mSupportedPlaces.add("bicycle store");
		mSupportedPlaces.add("book store");
		mSupportedPlaces.add("bowling alley");
		mSupportedPlaces.add("bus station");
		mSupportedPlaces.add("cafe");
		mSupportedPlaces.add("campground");
		mSupportedPlaces.add("car dealer");
		mSupportedPlaces.add("car rental");
		mSupportedPlaces.add("car repair");
		mSupportedPlaces.add("car wash");
		mSupportedPlaces.add("casino");
		mSupportedPlaces.add("cemetery");
		mSupportedPlaces.add("church");
		mSupportedPlaces.add("city hall");
		mSupportedPlaces.add("clothing store");
		mSupportedPlaces.add("convenience store");
		mSupportedPlaces.add("courthouse");
		mSupportedPlaces.add("dentist");
		mSupportedPlaces.add("department store");
		mSupportedPlaces.add("doctor");
		mSupportedPlaces.add("electrician");
		mSupportedPlaces.add("electronics store");
		mSupportedPlaces.add("embassy");
		mSupportedPlaces.add("establishment");
		mSupportedPlaces.add("finance");
		mSupportedPlaces.add("fire station");
		mSupportedPlaces.add("florist");
		mSupportedPlaces.add("food");
		mSupportedPlaces.add("funeral home");
		mSupportedPlaces.add("furniture store");
		mSupportedPlaces.add("gas station");
		mSupportedPlaces.add("general contractor");
		mSupportedPlaces.add("grocery or supermarket");
		mSupportedPlaces.add("gym");
		mSupportedPlaces.add("hair care");
		mSupportedPlaces.add("hardware store");
		mSupportedPlaces.add("health");
		mSupportedPlaces.add("hindu temple");
		mSupportedPlaces.add("home goods store");
		mSupportedPlaces.add("hospital");
		mSupportedPlaces.add("insurance agency");
		mSupportedPlaces.add("jewelry store");
		mSupportedPlaces.add("laundry");
		mSupportedPlaces.add("lawyer");
		mSupportedPlaces.add("library");
		mSupportedPlaces.add("liquor store");
		mSupportedPlaces.add("local government office");
		mSupportedPlaces.add("locksmith");
		mSupportedPlaces.add("lodging");
		mSupportedPlaces.add("meal delivery");
		mSupportedPlaces.add("meal takeaway");
		mSupportedPlaces.add("mosque");
		mSupportedPlaces.add("movie rental");
		mSupportedPlaces.add("movie theater");
		mSupportedPlaces.add("moving company");
		mSupportedPlaces.add("museum");
		mSupportedPlaces.add("night club");
		mSupportedPlaces.add("painter");
		mSupportedPlaces.add("park");
		mSupportedPlaces.add("parking");
		mSupportedPlaces.add("pet store");
		mSupportedPlaces.add("pharmacy");
		mSupportedPlaces.add("physiotherapist");
		mSupportedPlaces.add("place of worship");
		mSupportedPlaces.add("plumber");
		mSupportedPlaces.add("police");
		mSupportedPlaces.add("post office");
		mSupportedPlaces.add("real estate agency");
		mSupportedPlaces.add("restaurant");
		mSupportedPlaces.add("roofing contractor");
		mSupportedPlaces.add("rv park");
		mSupportedPlaces.add("school");
		mSupportedPlaces.add("shoe store");
		mSupportedPlaces.add("shopping mall");
		mSupportedPlaces.add("spa");
		mSupportedPlaces.add("stadium");
		mSupportedPlaces.add("storage");
		mSupportedPlaces.add("store");
		mSupportedPlaces.add("subway station");
		mSupportedPlaces.add("synagogue");
		mSupportedPlaces.add("taxi stand");
		mSupportedPlaces.add("train station");
		mSupportedPlaces.add("travel agency");
		mSupportedPlaces.add("university");
		mSupportedPlaces.add("veterinary care");
		mSupportedPlaces.add("zoo");
	}
}
