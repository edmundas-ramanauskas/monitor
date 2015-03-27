package com.marketplace.monitor.jms.listeners;

/**
 *
 * @author edmundas
 */
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;

/**
 *
 * @author edmundas
 */
public class EventListener implements MessageListener {
    
    private static final Logger logger = LoggerFactory.getLogger(EventListener.class);
    
    private JmsTemplate producerTemplate;
    
    @Override
    public void onMessage(Message message) {
        try {
            TextMessage event = (TextMessage) message;
            logger.info(event.getText());
            
            for(int i = 0; i < 20; i++) {
                producerTemplate.convertAndSend("monitor.system.task.in", "Task " + i);
            }
        } catch (JMSException ex) {
            logger.error("Error reading message", ex);
        }
    }
    
    public void setProducerTemplate(JmsTemplate producerTemplate) {
        this.producerTemplate = producerTemplate;
    }
}