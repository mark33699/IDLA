package com.example.idla;

public class Lesson
{
    public String no;
    public String title;
    public String desc;
    public int ImageResourceID;
    public Class activityClass;

    public Lesson(String no, String title, String desc, int imageResourceID, Class activityClass)
    {
        this.no = no;
        this.title = title;
        this.desc = desc;
        ImageResourceID = imageResourceID;
        this.activityClass = activityClass;
    }
}
