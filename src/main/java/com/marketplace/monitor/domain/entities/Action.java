package com.marketplace.monitor.domain.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author edmundas
 */
@Entity
public class Action extends AbstractEntity implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long actionId;
    @ManyToOne
    @JoinColumn(name = "actionDefId")
    private ActionDef actionDef;
    @Column
    private String state;
    @Column
    private String metadata;
    @ManyToOne
    @JoinColumn(name = "taskId")
    private Task task;
    
    public Action(Task task, ActionDef actionDef) {
        setTask(task);
        setActionDef(actionDef);
    }

    public long getActionId() {
        return actionId;
    }

    public void setActionId(long actionId) {
        this.actionId = actionId;
    }

    public ActionDef getActionDef() {
        return actionDef;
    }

    public void setActionDef(ActionDef actionDef) {
        this.actionDef = actionDef;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}