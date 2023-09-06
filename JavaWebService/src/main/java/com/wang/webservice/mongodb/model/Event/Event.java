package com.wang.webservice.mongodb.model.Event;

import com.wang.webservice.mongodb.model.Event.EventType.EventType;
import org.bson.types.ObjectId;

import java.util.Date;

public class Event {
    private ObjectId eventID;
    private String eventTitle;
    private String description;
    private EventType eventType;
    private float startTime;
    private float endTime;
    private Date startDate;
    private Date endDate;
    private String repetitionFrequency;

    public Event() {
        this.eventID = new ObjectId();
        this.eventTitle = "";
        this.description = "";
        this.eventType = new EventType();
        this.startTime = 0;
        this.endTime = 0;
        this.startDate = new Date();
        this.endDate = new Date();
        this.repetitionFrequency = "";
    }

    public Event( String eventTitle, String description, EventType eventType, float startTime, float endTime, Date startDate, Date endDate, String repetitionFrequency) {
        this.eventID = new ObjectId();
        this.eventTitle = eventTitle;
        this.description = description;
        this.eventType = eventType;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startDate = startDate;
        this.endDate = endDate;
        this.repetitionFrequency = repetitionFrequency;
    }

    public ObjectId getEventID() {
        return eventID;
    }

//    public void setEventID(String eventID) {
//        this.eventID = new ObjectId(eventID);
//    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public float getStartTime() {
        return startTime;
    }

    public void setStartTime(float startTime) {
        this.startTime = startTime;
    }

    public float getEndTime() {
        return endTime;
    }

    public void setEndTime(float endTime) {
        this.endTime = endTime;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getRepetitionFrequency() {
        return repetitionFrequency;
    }

    public void setRepetitionFrequency(String repetitionFrequency) {
        this.repetitionFrequency = repetitionFrequency;
    }
}
