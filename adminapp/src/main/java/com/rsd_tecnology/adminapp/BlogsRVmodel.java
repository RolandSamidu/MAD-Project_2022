package com.rsd_tecnology.adminapp;

import android.os.Parcel;
import android.os.Parcelable;

public class BlogsRVmodel implements Parcelable {
    private String blogId;
    private String blogDate;
    private String blogTopic;
    private String blogImage;
    private String blogCategory;
    private String blogDescription;
    private String blogID;




    public BlogsRVmodel(){

    }

    public BlogsRVmodel(String blogId, String blogDate, String blogTopic, String blogImage, String blogCategory, String blogDescription, String blogID) {
        this.blogId = blogId;
        this.blogDate = blogDate;
        this.blogTopic = blogTopic;
        this.blogImage = blogImage;
        this.blogCategory = blogCategory;
        this.blogDescription = blogDescription;
        this.blogID = blogID;
    }

    protected BlogsRVmodel(Parcel in) {
        blogId = in.readString();
        blogDate = in.readString();
        blogTopic = in.readString();
        blogImage = in.readString();
        blogCategory = in.readString();
        blogDescription = in.readString();
    }

    public static final Creator<BlogsRVmodel> CREATOR = new Creator<BlogsRVmodel>() {
        @Override
        public BlogsRVmodel createFromParcel(Parcel in) {
            return new BlogsRVmodel(in);
        }

        @Override
        public BlogsRVmodel[] newArray(int size) {
            return new BlogsRVmodel[size];
        }
    };

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public String getBlogDate() {
        return blogDate;
    }

    public void setBlogDate(String blogDate) {
        this.blogDate = blogDate;
    }

    public String getBlogTopic() {
        return blogTopic;
    }

    public void setBlogTopic(String blogTopic) {
        this.blogTopic = blogTopic;
    }

    public String getBlogImage() {
        return blogImage;
    }

    public void setBlogImage(String blogImage) {
        this.blogImage = blogImage;
    }

    public String getBlogCategory() {
        return blogCategory;
    }

    public void setBlogCategory(String blogCategory) {
        this.blogCategory = blogCategory;
    }

    public String getBlogDescription() {
        return blogDescription;
    }

    public void setBlogDescription(String blogDescription) {
        this.blogDescription = blogDescription;
    }

    public String getBlogID() {
        return blogID;
    }

    public void setBlogID(String blogID) {
        this.blogID = blogID;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(blogId);
        parcel.writeString(blogDate);
        parcel.writeString(blogTopic);
        parcel.writeString(blogImage);
        parcel.writeString(blogCategory);
        parcel.writeString(blogDescription);
        parcel.writeString(blogID);
    }
}
