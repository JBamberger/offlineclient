package de.jbamberger.offlinefetcher.source.jodel.model;

import android.os.Parcel;
import android.os.Parcelable;

public class LocationTag implements Parcelable {
    public static final Creator<LocationTag> CREATOR = new Creator<LocationTag>() {
        public LocationTag createFromParcel(Parcel parcel) {
            return new LocationTag(parcel);
        }

        public LocationTag[] newArray(int i) {
            return new LocationTag[i];
        }
    };
    public final String name;
    public final String placeId;

    public LocationTag(String str, String str2) {
        this.placeId = str;
        this.name = str2;
    }

    protected LocationTag(Parcel parcel) {
        this.placeId = parcel.readString();
        this.name = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.placeId);
        parcel.writeString(this.name);
    }

    public String toString() {
        return "LocationTag{placeId='" + this.placeId + '\'' + ", name='" + this.name + '\'' + '}';
    }
}
