package com.marketplace.monitor.domain.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author edmundas
 */
@Entity
public class ActionDef extends AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long actionDefId;
    @Column
    private String actionName;
    @ManyToMany(mappedBy="actionDefs")
    private List<TaskDef> taskDefs;

    public long getActionDefId() {
        return actionDefId;
    }

    public void setActionDefId(long actionDefId) {
        this.actionDefId = actionDefId;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public List<TaskDef> getTaskDefs() {
        return taskDefs;
    }

    public void setTaskDefs(List<TaskDef> taskDefs) {
        this.taskDefs = taskDefs;
    }
}