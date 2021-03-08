package com.example.recyclerviewassignments;

public class PersonInfo {
   private String username;
   private String time;
   private String date;
   private String flow;
   private String location;
   private String color;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFlow() {
        return flow;
    }

    public void setFlow(String flow) {
        this.flow = flow;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public PersonInfo(String username, String time, String date, String flow, String location, String color) {
        this.username = username;
        this.time = time;
        this.date = date;
        this.flow = flow;
        this.location = location;
        this.color = color;
    }
}
