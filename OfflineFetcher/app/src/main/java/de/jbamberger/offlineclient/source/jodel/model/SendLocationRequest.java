package de.jbamberger.offlineclient.source.jodel.model;

public class SendLocationRequest {
    public Location location;

    public SendLocationRequest(Location location) {
        this.location = location;
    }

    public String toString() {
        return this.location.toString();
    }
}
