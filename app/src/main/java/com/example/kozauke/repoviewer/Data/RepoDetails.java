package com.example.kozauke.repoviewer.Data;

import android.arch.lifecycle.MutableLiveData;
import android.os.Parcel;
import android.os.Parcelable;

public class RepoDetails extends MutableLiveData<RepoDetails> implements Parcelable {

    //TODO: dać więcej iinfo
    //Example: https://api.github.com/repos/marcinkozak-p/AndroidTask_ab
    public String mName = "NULL";
    public String mDescription = "NULL";

    public RepoDetails(){

    }
    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description){
        mDescription=description;
    }

    private RepoDetails(Parcel in) {
        mName = in.readString();
        mDescription = in.readString();
    }

    /**
     * Describe the kinds of special objects contained in this Parcelable
     * instance's marshaled representation. For example, if the object will
     * include a file descriptor in the output of {@link #writeToParcel(Parcel, int)},
     * the return value of this method must include the
     * {@link #CONTENTS_FILE_DESCRIPTOR} bit.
     *
     * @return a bitmask indicating the set of special object types marshaled
     * by this Parcelable object instance.
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Flatten this object in to a Parcel.
     *
     * @param dest  The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeString(mDescription);
    }

    public static final Parcelable.Creator<RepoDetails> CREATOR
            = new Parcelable.Creator<RepoDetails>() {
        public RepoDetails createFromParcel(Parcel in) {
            return new RepoDetails(in);
        }

        public RepoDetails[] newArray(int size) {
            return new RepoDetails[size];
        }
    };

}
