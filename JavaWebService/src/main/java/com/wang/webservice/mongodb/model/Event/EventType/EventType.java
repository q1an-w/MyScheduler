package com.wang.webservice.mongodb.model.Event.EventType;

public class EventType {
    private String typeName;
    private String typeColor;
    public EventType(){
        this.typeName = "default";
        this.typeColor = "default";
    }
    public EventType(String typeName, String typeColor) {
        this.typeName = typeName;
        this.typeColor = typeColor;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeColor() {
        return typeColor;
    }

    public void setTypeColor(String typeColor) {
        this.typeColor = typeColor;
    }
}
