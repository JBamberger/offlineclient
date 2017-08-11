package de.jbamberger.offlinefetcher.source.jodel.model;

import android.location.Address;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Location implements Parcelable {
    public static final Creator<Location> CREATOR = new Creator<Location>() {
        public Location createFromParcel(Parcel parcel) {
            return new Location(parcel);
        }

        public Location[] newArray(int i) {
            return new Location[i];
        }
    };
    @SerializedName("loc_accuracy")
    public final float accuracy;
    public final String city;
    @SerializedName("loc_coordinates")
    public final Coordinates coordinates;
    public final String country;
    public final String name;

    public Location(String str, String str2, String str3, double d, double d2, float f) {
        this.name = str;
        this.city = str2;
        this.country = str3;
        this.coordinates = new Coordinates(d, d2);
        this.accuracy = f;
    }

    public Location(String str, String str2, String str3, Coordinates coordinates, float f) {
        this.name = str;
        this.city = str2;
        this.country = str3;
        this.coordinates = coordinates;
        this.accuracy = f;
    }

    public Location(Address address) {
        this(address.getLocality(), address.getLocality(), address.getCountryCode(), new Coordinates(address.getLatitude(), address.getLongitude()), 0.0f);
    }

    public double getLatitude() {
        return this.coordinates.latitude;
    }

    public double getLongitude() {
        return this.coordinates.longitude;
    }

    public float getAccuracy() {
        return this.accuracy;
    }

    public Location(Parcel parcel) {
        this.name = parcel.readString();
        this.city = parcel.readString();
        this.country = parcel.readString();
        this.coordinates = (Coordinates) parcel.readParcelable(getClass().getClassLoader());
        this.accuracy = parcel.readFloat();
    }

    public String toString() {
        return "Location{name='" + this.name + '\'' + ", city='" + this.city + '\'' + ", country='" + this.country + '\'' + ", coordinates=" + this.coordinates + ", accuracy=" + this.accuracy + '}';
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.city);
        parcel.writeString(this.country);
        parcel.writeParcelable(this.coordinates, 0);
        parcel.writeFloat(this.accuracy);
    }
}
