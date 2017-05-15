package com.prototype.move2live.ui;

/**
 * Created by kt_ki on 5/10/2017.
 */

public class UserDetailsForBlog {
    private String blog;
    private String name;
    private String time;
    private String date;
    private String photoUrl;

    public UserDetailsForBlog() {
    }

    public UserDetailsForBlog(String text, String name,String date, String time, String photoUrl) {
        this.blog = text;
        this.name = name;
        this.date = date;
        this.time = time;
        this.photoUrl = photoUrl;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(String time){
        this.time = time;
    }

    public String getTime(){
        return time;
    }

    public void setDate(String date){
        this.date = date;
    }

    public String getDate(){
        return date;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
