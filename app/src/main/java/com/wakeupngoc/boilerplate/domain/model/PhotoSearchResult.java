package com.wakeupngoc.boilerplate.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PhotoSearchResult implements Parcelable {

    @SerializedName("photoResults")
    @Expose
    public PhotoResults photoResults;
    @SerializedName("stat")
    @Expose
    public String stat;

    /**
     * No args constructor for use in serialization
     *
     */
    public PhotoSearchResult() {
    }

    /**
     *
     * @param photoResults
     * @param stat
     */
    public PhotoSearchResult(PhotoResults photoResults, String stat) {
        super();
        this.photoResults = photoResults;
        this.stat = stat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhotoSearchResult that = (PhotoSearchResult) o;

        if (!photoResults.equals(that.photoResults)) return false;
        return stat.equals(that.stat);

    }

    @Override
    public int hashCode() {
        int result = photoResults.hashCode();
        result = 31 * result + stat.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PhotoSearchResult{" +
            "photoResults=" + photoResults +
            ", stat='" + stat + '\'' +
            '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.photoResults, flags);
        dest.writeString(this.stat);
    }

    protected PhotoSearchResult(Parcel in) {
        this.photoResults = in.readParcelable(PhotoResults.class.getClassLoader());
        this.stat = in.readString();
    }

    public static final Parcelable.Creator<PhotoSearchResult> CREATOR = new Parcelable.Creator<PhotoSearchResult>() {
        @Override
        public PhotoSearchResult createFromParcel(Parcel source) {
            return new PhotoSearchResult(source);
        }

        @Override
        public PhotoSearchResult[] newArray(int size) {
            return new PhotoSearchResult[size];
        }
    };
}