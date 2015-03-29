package com.marketplace.monitor.jms.listeners;

/**
 *
 * @author edmundas
 */
import com.marketplace.monitor.domain.entities.Website;
import com.marketplace.monitor.domain.repositories.WebsiteRepository;
import com.marketplace.monitor.jms.messages.EventMessage;
import com.marketplace.monitor.jms.messages.TaskMessage;
import java.util.List;
import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
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
    @Resource
    private WebsiteRepository websiteRepository;
    
    @Override
    public void onMessage(Message message) {
        EventMessage event = null;
        try {
            event = (EventMessage) ((ObjectMessage) message).getObject();
        } catch (JMSException ex) {
            logger.error("Error reading message", ex);
        }
        
        if(event != null) {
            if(event.getEventType() == EventMessage.EventType.INIT_MONITORING_TASK) {
                List<Website> websites = websiteRepository.findAll();
                for(Website website : websites) {
                    producerTemplate.convertAndSend("monitor.system.task.in", new TaskMessage(website));
                }
            }
        }
    }
    
    public void setProducerTemplate(JmsTemplate producerTemplate) {
        this.producerTemplate = producerTemplate;
    }
}