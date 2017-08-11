package de.jbamberger.offlinefetcher.source.jodel.model;

public class LocationUpdateResponse {
    private final String city;
    private final String country;
    private final double[] loc;
    private final String name;
    private final int radius;

    public LocationUpdateResponse(String str, String str2, String str3, int i, double[] dArr) {
        this.name = str;
        this.country = str2;
        this.city = str3;
        this.radius = i;
        this.loc = dArr;
    }

    public String getName() {
        return this.name;
    }

    public String getCountry() {
        return this.country;
    }

    public String getCity() {
        return this.city;
    }

    public int getRadius() {
        return this.radius;
    }

    public Coordinates getCoordinates() {
        return new Coordinates(this.loc[1], this.loc[0]);
    }

    public double getLatitude() {
        return this.loc[1];
    }

    public double getLongitude() {
        return this.loc[0];
    }
}
