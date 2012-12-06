package org.gmarz.googleplaces.models;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Parcel;
import android.os.Parcelable;

public class PlaceDetails implements Parcelable {
	
	private String mPhoneNumber = "";
	private String mWebsite = "";
	private ArrayList<PlaceReview> mReviews = new ArrayList<PlaceReview>();

	private PlaceDetails(Parcel in) {
		mPhoneNumber = in.readString();
		mWebsite = in.readString();
		in.readTypedList(mReviews, PlaceReview.CREATOR);
	}

	private PlaceDetails() {
		// Do nothing.  For returning an empty object when a place has no details.
	}
	
	public PlaceDetails(JSONObject jsonDetail) {
		try {
			mPhoneNumber = jsonDetail.getString("formatted_phone_number");
			
			if (jsonDetail.has("website")) {
				mWebsite = jsonDetail.getString("website");
			}

			JSONArray jsonReviews = jsonDetail.getJSONArray("reviews");
			
			for(int i =0;i<jsonReviews.length();i++) {
				PlaceReview review = new PlaceReview(jsonReviews.getJSONObject(i));
				mReviews.add(review);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	public static PlaceDetails getEmpty() {
		return new PlaceDetails();
	}
	
	public String getPhoneNumber() {
		return mPhoneNumber;
	}
	
	public boolean phoneNumerIsValid() {
		return mPhoneNumber.matches("^\\(?([0-9]{3})\\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$");
	}

	public String getWebsite() {
		return mWebsite;
	}
	
	public boolean websiteIsValid() {
		return (mWebsite != "");
	}
	
	public ArrayList<PlaceReview> getReviews() {
		return mReviews;
	}
	
	public boolean hasReviews() {
		return (mReviews.size() > 0);
	}
	
	public int describeContents() {
		return 0;
	}

	public void writeToParcel(Parcel out, int flags) {
		out.writeString(mPhoneNumber);
		out.writeString(mWebsite);
		out.writeTypedList(mReviews);
	}
	
	public static final Parcelable.Creator<PlaceDetails> CREATOR = new Parcelable.Creator<PlaceDetails>() {

		public PlaceDetails createFromParcel(Parcel in) {
			return new PlaceDetails(in);
		}

		public PlaceDetails[] newArray(int size) {
			return new PlaceDetails[size];
		}
	};
}
