package com.marketplace.monitor.domain.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
public class Task extends AbstractEntity implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long taskId;
    @ManyToOne
    @JoinColumn(name = "taskDefId")
    private TaskDef taskDef;
    @Column
    private String state;
    @Column
    private String metadata;
    @OneToMany(fetch = FetchType.EAGER, mappedBy="task")
    private List<Action> actions;
    
    public Task(TaskDef taskDef) {
        setTaskDef(taskDef);
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public TaskDef getTaskDef() {
        return taskDef;
    }

    public void setTaskDef(TaskDef taskDef) {
        this.taskDef = taskDef;
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

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }
}