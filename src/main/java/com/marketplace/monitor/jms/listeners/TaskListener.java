package com.marketplace.monitor.jms.listeners;

import com.marketplace.monitor.domain.entities.Action;
import com.marketplace.monitor.domain.entities.ActionDef;
import com.marketplace.monitor.domain.entities.Task;
import com.marketplace.monitor.domain.entities.TaskDef;
import com.marketplace.monitor.domain.entities.Website;
import com.marketplace.monitor.domain.repositories.ActionRepository;
import com.marketplace.monitor.domain.repositories.TaskRepository;
import com.marketplace.monitor.jms.messages.ActionMessage;
import com.marketplace.monitor.jms.messages.TaskMessage;
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
public class TaskListener implements MessageListener {
    
    private static final Logger logger = LoggerFactory.getLogger(TaskListener.class);
    
    private JmsTemplate producerTemplate;
    @Resource
    private TaskRepository taskRepository;
    @Resource
    private ActionRepository actionRepository;
    
    @Override
    public void onMessage(Message message) {
        try {
            TaskMessage taskMessage = (TaskMessage) ((ObjectMessage) message).getObject();
            Website website = (Website) taskMessage.getData();
            TaskDef taskDef = website.getMonitor().getTaskDef();
            Task task = new Task(taskDef);
            task.setState("progressing");
            taskRepository.save(task);
            for(ActionDef actionDef : taskDef.getActionDefs()) {
                Action action = new Action(task, actionDef);
                action.setState("progressing");
                actionRepository.save(action);
                producerTemplate.convertAndSend("monitor.system.action.in", new ActionMessage(action));
            }
        } catch (JMSException ex) {
            logger.error("Error reading message", ex);
        }
    }
    
    public void setProducerTemplate(JmsTemplate producerTemplate) {
        this.producerTemplate = producerTemplate;
    }
}