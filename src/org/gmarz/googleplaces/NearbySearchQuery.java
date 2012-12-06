package org.gmarz.googleplaces;

import android.location.Location;

public class NearbySearchQuery extends SearchQuery {

	public enum Ranking { Prominence, Distance };
	
	public NearbySearchQuery(Location location, int radius, boolean sensor) {
		this(location.getLatitude(), location.getLongitude(), radius, sensor);
	}

	public NearbySearchQuery(double lat, double lon, int radius, boolean sensor) {
		super(sensor);
		setLocation(lat, lon);
		setRadius(radius);
	}
	
	public void setRanking(Ranking ranking)	{
		mQueryBuilder.addParameter("rankby", ranking.toString());
	}
	
	public void setKeyword(String keyword) {
		mQueryBuilder.addParameter("keyword", keyword);
	}
	
	public void setName(String name) {
		mQueryBuilder.addParameter("name", name);	
	}
	
	public void setPageToken(String pageToken) {
		mQueryBuilder.addParameter("pagetoken", pageToken);
	}

	@Override
	public String getUrl() {
		return "https://maps.googleapis.com/maps/api/place/search/json";
	}
}
