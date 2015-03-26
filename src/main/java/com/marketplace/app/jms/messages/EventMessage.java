package com.marketplace.app.jms.messages;

import java.io.Serializable;

/**
 *
 * @author edmundas
 */
public class EventMessage implements Serializable {
    
    private final String details;
    
    public EventMessage(String details) {
        this.details = details;
    }
    
    public String getDetails() {
        return details;
    }
}