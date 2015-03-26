package com.marketplace.app.jms.listeners;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author edmundas
 */
public class TaskListener implements MessageListener {
    
    private static final Logger logger = LoggerFactory.getLogger(TaskListener.class);
    
    @Override
    public void onMessage(Message message) {
        try {
            TextMessage event = (TextMessage) message;
            logger.info(event.getText() + " " + Thread.currentThread().getName());
        } catch (JMSException ex) {
            logger.error("Error reading message", ex);
        }
    }
}