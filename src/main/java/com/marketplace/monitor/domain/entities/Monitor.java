package com.marketplace.monitor.domain.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author edmundas
 */
@Entity
public class Monitor extends AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long monitorId;
    @Column
    private String monitorName;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "taskDefId")
    private TaskDef taskDef;

    public long getMonitorId() {
        return monitorId;
    }

    public void setMonitorId(long monitorId) {
        this.monitorId = monitorId;
    }

    public String getMonitorName() {
        return monitorName;
    }

    public void setMonitorName(String monitorName) {
        this.monitorName = monitorName;
    }

    public TaskDef getTaskDef() {
        return taskDef;
    }

    public void setTaskDef(TaskDef taskDef) {
        this.taskDef = taskDef;
    }
}