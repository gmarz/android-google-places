package org.gmarz.googleplaces;

public class DetailsQuery extends Query {

	public DetailsQuery(String reference, boolean sensor) {
		super(sensor);
		mQueryBuilder.addParameter("reference", reference);
	}
	
	@Override
	public String getUrl() {
		return "https://maps.googleapis.com/maps/api/place/details/json";
	}

}