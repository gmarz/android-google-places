package org.gmarz.googleplaces.query;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

class QueryBuilder {
	
	private List<NameValuePair> mParameters = new ArrayList<NameValuePair>();
	
	public void addParameter(String name, String value) {
		removeParameter(name);
		mParameters.add(new BasicNameValuePair(name,value));
	}
	
	public void removeParameter(String name) {
		if (mParameters.contains(name)) {
			mParameters.remove(name);
		}
	}
	
	public void clearParameters() {
		mParameters.clear();
	}
	
	public String toString() {
		StringBuilder query = new StringBuilder();
		NameValuePair parameter = null;
		
		query.append("?");
		
		for(int i = 0; i < mParameters.size(); i++) {
			parameter = mParameters.get(i);
			query.append(parameter.getName());
			query.append("=");
			query.append(parameter.getValue());
			query.append("&");
		}
		
		return encode(query.toString());
	}
	
	private String encode(String query) {
		String encodedQuery = query.replace("|", "%7C");
		encodedQuery = encodedQuery.replace(' ', '+');
		
		return encodedQuery;
	}
}
