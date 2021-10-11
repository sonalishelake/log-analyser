package com.github.sonalishelake.loganalyser.model.persistence;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.sonalishelake.loganalyser.model.EventInfo;
import com.github.sonalishelake.loganalyser.model.EventTypeInfo;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alerts")
public class Alert {
    @Id
    @JsonProperty("id")
    private String id;

    @JsonProperty("duration")
    private int duration;

    @JsonProperty("type")
    private EventTypeInfo type;

    @JsonProperty("host")
    private String host;

    @JsonProperty("alert")
    private Boolean alert;

    public Alert() {
    }

    public Alert(EventInfo event, int duration) {
        this.id = event.getId();
        this.type = event.getType();
        this.host = event.getHost();
        this.duration = duration;
        this.alert = Boolean.FALSE;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
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

    public Boolean getAlert() {
        return alert;
    }

    public void setAlert(Boolean alert) {
        this.alert = alert;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}