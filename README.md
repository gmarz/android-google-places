Android library that wraps the Google Places API.

Setup
=====

1) Obtain an API key.  Visit the <a href="https://developers.google.com/places/documentation/">developer's guide</a> for more information.

2) Drop the googleplaces.jar in the lib folder of your Android project.

Usage
=====

A few examples...

Place Search
------------

Sending a Nearby Search request

    GooglePlaces googlePlaces = new GooglePlaces("Your API Key");

    NearbySearchQuery query = new NearbySearchQuery(40.764941, -73.984886);
    query.setRadius(500);
    query.addType("food");
    query.addType("restaurant");
    query.setKeyword("steakhouse");
    
    PlacesResult result = googlePlaces.getPlaces(query);

Sending a Text Search request

    TextSearchQuery query = new TextSearchQuery("24 hour diners");
    query.setLocation(40.764941, -73.984886);
    query.setRadius(500);
    
    PlacesResult result = googlePlaces.getPlaces(query);

Handling a place search response

    if (result.getStatusCode() == StatusCode.OK) {
        List<Place> places = result.getPlaces();
    }
        
Place Details
-------------

Sending a Place Details request

    Place somePlace = result.getPlaces().get(0);
    
    DetailsQuery query = new DetailsQuery(somePlace.getReference());
    
    DetailsResult detailsResult = googlePlaces.getPlaceDetails(query);

Handling a place details response

    if (detailsResult.getStatusCode() == StatusCode.OK) {
        PlaceDetails details = detailsResult.getDetails();
    }

Contributing
============

Fork, push, and send a pull request.