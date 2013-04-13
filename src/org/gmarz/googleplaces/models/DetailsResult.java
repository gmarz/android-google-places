package org.gmarz.googleplaces.models;

import org.json.JSONException;
import org.json.JSONObject;


public class DetailsResult extends Result {

	private PlaceDetails mDetails;
	
	public DetailsResult(JSONObject jsonResponse) throws JSONException {
		super(jsonResponse);
		
		if (jsonResponse.has("result")) {
			JSONObject result = jsonResponse.getJSONObject("result");
			mDetails = new PlaceDetails(result);
		} else {
			mDetails = PlaceDetails.getEmpty();
		}
	}

	public PlaceDetails getDetails() {
		return mDetails;
	}
}
