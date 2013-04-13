package org.gmarz.googleplaces.models;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class Result {

	public enum StatusCode
	{
		OK,
		ZeroResults,
		OverQueryLimit,
		RequestDenied,
		InvalidRequest,
		Unknown
	}
	
	public static final String STATUS_CODE_OK = "OK";
	public static final String STATUS_CODE_ZERO_RESULTS = "ZERO_RESULTS";
	public static final String STATUS_CODE_OVER_QUERY_LIMIT = "OVER_QUERY_LIMIT";
	public static final String STATUS_CODE_REQUEST_DENIED = "REQUEST_DENIED";
	public static final String STATUS_CODE_INVALID_REQUEST = "INVALID_REQUEST";
	
	private StatusCode mStatusCode;
	private String mStatusCodeValue = "";
	
	public Result(JSONObject jsonResponse) throws JSONException {
		if (jsonResponse.has("status")) {
			mStatusCode = getStatusCodeFromValue(jsonResponse.getString("status"));
		} else {
			mStatusCode = StatusCode.Unknown;
		}
	}
	
	public StatusCode getStatusCode() {
		return mStatusCode;
	}
	
	public String getStatusCodeValue() {
		return mStatusCodeValue;
	}
	
	public boolean requestSucceeded() {
		return (mStatusCode == StatusCode.OK || mStatusCode == StatusCode.ZeroResults);
	}
	
	protected StatusCode getStatusCodeFromValue(String statusCodeValue) {
		if (statusCodeValue.equals(STATUS_CODE_OK)) {
			return StatusCode.OK;
		} else if (statusCodeValue.equals(STATUS_CODE_ZERO_RESULTS)) {
			return StatusCode.ZeroResults;
		} else if (statusCodeValue.equals(STATUS_CODE_OVER_QUERY_LIMIT)) {
			return StatusCode.OverQueryLimit;
		} else if (statusCodeValue.equals(STATUS_CODE_REQUEST_DENIED)) {
			return StatusCode.RequestDenied;
		} else if (statusCodeValue.equals(STATUS_CODE_INVALID_REQUEST)) {
			return StatusCode.InvalidRequest;
		} else {
			return StatusCode.Unknown;
		}
	}
}
