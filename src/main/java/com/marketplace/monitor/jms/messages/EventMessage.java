package com.marketplace.monitor.jms.messages;

import java.io.Serializable;

/**
 *
 * @author edmundas
 */
public class EventMessage extends AbstractMessage implements Serializable {
    
    private EventType eventType;
    
    public EventMessage() {
        
    }
    
    public EventMessage(EventType eventType) {
        this.eventType = eventType;
    }
    
    public EventType getEventType() {
        return eventType;
    }
    
    public enum EventType {
        INIT_MONITORING_TASK;
    }
}