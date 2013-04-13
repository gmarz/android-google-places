package org.gmarz.googleplaces.models;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PlacesResult extends Result {

	private List<Place> mPlaces = new ArrayList<Place>();
	
	public PlacesResult(JSONObject jsonResponse) throws JSONException {
		super(jsonResponse);
		
		if (jsonResponse.has("results")) {
			JSONArray results = jsonResponse.getJSONArray("results");
			
			for(int i = 0; i < results.length(); i++) {
				Place place = new Place(results.getJSONObject(i));
				mPlaces.add(place);
			}	
		}
	}

	public List<Place> getPlaces() {
		return mPlaces;
	}
}
