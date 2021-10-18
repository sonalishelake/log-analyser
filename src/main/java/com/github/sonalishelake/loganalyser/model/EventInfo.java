package com.github.sonalishelake.loganalyser.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class EventInfo {

    @JsonProperty("id")
    private String id;

    @JsonProperty("state")
    private StateInfo state;

    @JsonProperty("type")
    private EventTypeInfo type;

    @JsonProperty("host")
    private String host;

    @JsonProperty("timestamp")
    private long timestamp;

    //getter and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public StateInfo getState() {
        return state;
    }

    public void setState(StateInfo state) {
        this.state = state;
    }

    public EventTypeInfo getType() {
        return type;
    }

    public void setType(EventTypeInfo type) {
        this.type = type;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
