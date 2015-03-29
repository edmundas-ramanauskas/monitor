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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author edmundas
 */
@Entity
public class TaskDef extends AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long taskDefId;
    @Column
    private String taskName;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="TaskActionMap",
            joinColumns={@JoinColumn(name="taskDefId", referencedColumnName="taskDefId")},
            inverseJoinColumns={@JoinColumn(name="actionDefId", referencedColumnName="actionDefId")})
    private List<ActionDef> actionDefs;

    public long getTaskDefId() {
        return taskDefId;
    }

    public void setTaskDefId(long taskDefId) {
        this.taskDefId = taskDefId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public List<ActionDef> getActionDefs() {
        return actionDefs;
    }

    public void setActionDefs(List<ActionDef> actionDefs) {
        this.actionDefs = actionDefs;
    }
}
