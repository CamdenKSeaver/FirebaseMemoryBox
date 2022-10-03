package com.example.firebasememorybox;

import android.os.Parcel;
import android.os.Parcelable;

public class Memory implements Parcelable {
    private int rating;
    private String desc;
    private String name;
    private int imageResourceId;

    public Memory(int rating, String name, String desc, int imageResourceId) {
        this.rating = rating;
        this.name = name;
        this.desc = desc;
        this.imageResourceId = imageResourceId;
    }
    public Memory() {
        rating = 0;
        desc = "";
        name = "";
        imageResourceId = 0;
    }
    public Memory(Parcel parcel) {
        rating = parcel.readInt();
        name = parcel.readString();
        desc = parcel.readString();
        imageResourceId = parcel.readInt();
    }


    public static final Parcelable.Creator<Memory> CREATOR = new
            Parcelable.Creator<Memory>() {

                @Override
                public Memory createFromParcel(Parcel parcel) {
                    return new Memory(parcel);
                }

                @Override
                public Memory[] newArray(int size) {
                    return new Memory[0];
                }
            };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(rating);
        dest.writeString(name);
        dest.writeString(desc);
        dest.writeInt(imageResourceId);
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }
}
