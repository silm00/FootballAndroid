package com.example.footbaltest.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseLastMatch{

    @SerializedName("events")
    private List<EventsItem> events;

    public void setEvents(List<EventsItem> events){
        this.events = events;
    }

    public List<EventsItem> getEvents(){
        return events;
    }

    @Override
    public String toString(){
        return
                "ResponseLastMatch{" +
                        "events = '" + events + '\'' +
                        "}";
    }
}
