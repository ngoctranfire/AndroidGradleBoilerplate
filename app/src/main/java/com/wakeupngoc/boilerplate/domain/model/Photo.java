package com.wakeupngoc.boilerplate.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Locale;

public class Photo implements Parcelable {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("owner")
    @Expose
    public String owner;
    @SerializedName("secret")
    @Expose
    public String secret;
    @SerializedName("server")
    @Expose
    public String server;
    @SerializedName("farm")
    @Expose
    public long farm;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("ispublic")
    @Expose
    public long ispublic;
    @SerializedName("isfriend")
    @Expose
    public long isfriend;
    @SerializedName("isfamily")
    @Expose
    public long isfamily;

    /**
     * No args constructor for use in serialization
     *
     */
    public Photo() {
    }

    /**
     *
     * @param isfamily
     * @param farm
     * @param id
     * @param title
     * @param ispublic
     * @param owner
     * @param secret
     * @param server
     * @param isfriend
     */
    public Photo(String id, String owner, String secret, String server, long farm, String title, long ispublic, long isfriend, long isfamily) {
        super();
        this.id = id;
        this.owner = owner;
        this.secret = secret;
        this.server = server;
        this.farm = farm;
        this.title = title;
        this.ispublic = ispublic;
        this.isfriend = isfriend;
        this.isfamily = isfamily;
    }

    @Override
    public String toString() {
        return "Photo{" +
            "id='" + id + '\'' +
            ", owner='" + owner + '\'' +
            ", secret='" + secret + '\'' +
            ", server='" + server + '\'' +
            ", farm=" + farm +
            ", title='" + title + '\'' +
            ", ispublic=" + ispublic +
            ", isfriend=" + isfriend +
            ", isfamily=" + isfamily +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Photo photo = (Photo) o;

        if (farm != photo.farm) return false;
        if (ispublic != photo.ispublic) return false;
        if (isfriend != photo.isfriend) return false;
        if (isfamily != photo.isfamily) return false;
        if (!id.equals(photo.id)) return false;
        if (!owner.equals(photo.owner)) return false;
        if (!secret.equals(photo.secret)) return false;
        if (!server.equals(photo.server)) return false;
        return title.equals(photo.title);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + owner.hashCode();
        result = 31 * result + secret.hashCode();
        result = 31 * result + server.hashCode();
        result = 31 * result + (int) (farm ^ (farm >>> 32));
        result = 31 * result + title.hashCode();
        result = 31 * result + (int) (ispublic ^ (ispublic >>> 32));
        result = 31 * result + (int) (isfriend ^ (isfriend >>> 32));
        result = 31 * result + (int) (isfamily ^ (isfamily >>> 32));
        return result;
    }

    public static class PhotoBuilder {
        private String id;
        private String owner;
        private String secret;
        private String server;
        private long farm;
        private String title;
        private long ispublic;
        private long isfriend;
        private long isfamily;

        public PhotoBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public PhotoBuilder setOwner(String owner) {
            this.owner = owner;
            return this;
        }

        public PhotoBuilder setSecret(String secret) {
            this.secret = secret;
            return this;
        }

        public PhotoBuilder setServer(String server) {
            this.server = server;
            return this;
        }

        public PhotoBuilder setFarm(long farm) {
            this.farm = farm;
            return this;
        }

        public PhotoBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public PhotoBuilder setIspublic(long ispublic) {
            this.ispublic = ispublic;
            return this;
        }

        public PhotoBuilder setIsfriend(long isfriend) {
            this.isfriend = isfriend;
            return this;
        }

        public PhotoBuilder setIsfamily(long isfamily) {
            this.isfamily = isfamily;
            return this;
        }

        public Photo createPhoto() {
            return new Photo(id, owner, secret, server, farm, title, ispublic, isfriend, isfamily);
        }
    }

    public String createPhotoURL(String sizeSuffix) {
        return String.format(Locale.US, "https://farm%d.staticflickr.com/%s/%s_%s_%s.jpg",
            this.farm, this.server, this.id, this.secret, sizeSuffix);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.owner);
        dest.writeString(this.secret);
        dest.writeString(this.server);
        dest.writeLong(this.farm);
        dest.writeString(this.title);
        dest.writeLong(this.ispublic);
        dest.writeLong(this.isfriend);
        dest.writeLong(this.isfamily);
    }

    protected Photo(Parcel in) {
        this.id = in.readString();
        this.owner = in.readString();
        this.secret = in.readString();
        this.server = in.readString();
        this.farm = in.readLong();
        this.title = in.readString();
        this.ispublic = in.readLong();
        this.isfriend = in.readLong();
        this.isfamily = in.readLong();
    }

    public static final Parcelable.Creator<Photo> CREATOR = new Parcelable.Creator<Photo>() {
        @Override
        public Photo createFromParcel(Parcel source) {
            return new Photo(source);
        }

        @Override
        public Photo[] newArray(int size) {
            return new Photo[size];
        }
    };
}