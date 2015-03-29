package com.marketplace.monitor.jms.messages;

import java.io.Serializable;

/**
 *
 * @author edmundas
 */
public class TaskMessage extends AbstractMessage implements Serializable {
    
    private Object data;
    
    public TaskMessage() {
        
    }
    
    public TaskMessage(Object data) {
        setData(data);
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}