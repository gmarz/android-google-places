package org.gmarz.googleplaces;

public class TextSearchQuery extends SearchQuery {

	public TextSearchQuery(boolean sensor) {
		super(sensor);
	}

	public void setQuery(String query) {
		mQueryBuilder.addParameter("query", query);
	}

	@Override
	public String getUrl() {
		return "https://maps.googleapis.com/maps/api/place/textsearch/json";
	}
}
