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
    private String name;
    @ManyToMany(mappedBy="actions")
    private List<TaskDef> tasks;

    public long getActionDefId() {
        return actionDefId;
    }

    public void setActionDefId(long actionDefId) {
        this.actionDefId = actionDefId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TaskDef> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskDef> tasks) {
        this.tasks = tasks;
    }
}