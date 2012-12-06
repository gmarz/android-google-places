package org.gmarz.googleplaces;

public abstract class Query {

	protected QueryBuilder mQueryBuilder = new QueryBuilder();
	
	public Query(boolean sensor) {
		mQueryBuilder.addParameter("sensor", Boolean.toString(sensor));
	}
	
	public void setLanguage(String language) {
		mQueryBuilder.addParameter("language", language);
	}
	
	public abstract String getUrl();
	
	@Override
	public String toString() {
		return (getUrl() + mQueryBuilder.toString());
	}
}
