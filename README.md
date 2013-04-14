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

Sending a search request

    GooglePlaces googlePlaces = new GooglePlaces("Your API Key");
    
    PlacesResult result = googlePlaces.getPlaces("food", 500, 40.764941, -73.984886);
    
    PlacesResult result = googlePlaces.getPlaces("food", "steakhouse", 500, 40.764941, -73.984886);
    
    PlacesResult result = googlePlaces.getPlaces("diners", 40.764941, -73.984886);

Handling a place search response

    if (result.getStatusCode() == StatusCode.OK) {
        List<Place> places = result.getPlaces();
    }
        
Place Details
-------------

Sending a Place Details request

    Place somePlace = result.getPlaces().get(0);
    
    DetailsResult detailsResult = googlePlaces.getPlaceDetails(somePlace.getReference());

Handling a place details response

    if (detailsResult.getStatusCode() == StatusCode.OK) {
        PlaceDetails details = detailsResult.getDetails();
    }

Contributing
============

Fork, push, and send a pull request.
