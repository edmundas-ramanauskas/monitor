package com.marketplace.monitor.jms.listeners;

import com.marketplace.monitor.jms.messages.ActionMessage;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author edmundas
 */
public class ActionListener implements MessageListener {
    
    private static final Logger logger = LoggerFactory.getLogger(ActionListener.class);
    
    @Override
    public void onMessage(Message message) {
        try {
            ActionMessage actionMessage = (ActionMessage) ((ObjectMessage) message).getObject();
            logger.info(actionMessage.getData().getClass().toString());
        } catch (JMSException ex) {
            logger.error("Error reading message", ex);
        }
    }
}