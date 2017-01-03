package com.wakeupngoc.boilerplate.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PhotoResults implements Parcelable {

    @SerializedName("page")
    @Expose
    public long page;
    @SerializedName("pages")
    @Expose
    public long pages;
    @SerializedName("perpage")
    @Expose
    public long perpage;
    @SerializedName("total")
    @Expose
    public String total;
    @SerializedName("photoResults")
    @Expose
    public List<Photo> photos = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public PhotoResults() {
    }

    /**
     *
     * @param total
     * @param page
     * @param pages
     * @param photos
     * @param perpage
     */
    public PhotoResults(long page, long pages, long perpage, String total, List<Photo> photos) {
        super();
        this.page = page;
        this.pages = pages;
        this.perpage = perpage;
        this.total = total;
        this.photos = photos;
    }

    @Override
    public String toString() {
        return "PhotoResults{" +
            "page=" + page +
            ", pages=" + pages +
            ", perpage=" + perpage +
            ", total='" + total + '\'' +
            ", photoResults=" + photos +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhotoResults that = (PhotoResults) o;

        if (page != that.page) return false;
        if (pages != that.pages) return false;
        if (perpage != that.perpage) return false;
        if (!total.equals(that.total)) return false;
        return photos.equals(that.photos);

    }

    @Override
    public int hashCode() {
        int result = (int) (page ^ (page >>> 32));
        result = 31 * result + (int) (pages ^ (pages >>> 32));
        result = 31 * result + (int) (perpage ^ (perpage >>> 32));
        result = 31 * result + total.hashCode();
        result = 31 * result + photos.hashCode();
        return result;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.page);
        dest.writeLong(this.pages);
        dest.writeLong(this.perpage);
        dest.writeString(this.total);
        dest.writeTypedList(this.photos);
    }

    protected PhotoResults(Parcel in) {
        this.page = in.readLong();
        this.pages = in.readLong();
        this.perpage = in.readLong();
        this.total = in.readString();
        this.photos = in.createTypedArrayList(Photo.CREATOR);
    }

    public static final Parcelable.Creator<PhotoResults> CREATOR = new Parcelable.Creator<PhotoResults>() {
        @Override
        public PhotoResults createFromParcel(Parcel source) {
            return new PhotoResults(source);
        }

        @Override
        public PhotoResults[] newArray(int size) {
            return new PhotoResults[size];
        }
    };
}