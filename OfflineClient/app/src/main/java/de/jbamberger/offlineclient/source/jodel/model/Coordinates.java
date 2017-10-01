package de.jbamberger.offlineclient.source.jodel.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Coordinates implements Parcelable {
    public static final Creator<Coordinates> CREATOR = new Creator<Coordinates>() {
        public Coordinates createFromParcel(Parcel parcel) {
            return new Coordinates(parcel);
        }

        public Coordinates[] newArray(int i) {
            return new Coordinates[i];
        }
    };
    @SerializedName("lat")
    public double latitude;
    @SerializedName("lng")
    public double longitude;

    public Coordinates(double d, double d2) {
        this.latitude = d;
        this.longitude = d2;
    }

    public Coordinates(Parcel parcel) {
        this.latitude = parcel.readDouble();
        this.longitude = parcel.readDouble();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.latitude);
        parcel.writeDouble(this.longitude);
    }
}
