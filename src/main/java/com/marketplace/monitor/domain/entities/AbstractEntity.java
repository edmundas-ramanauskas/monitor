package com.marketplace.monitor.domain.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author edmundas
 */
@MappedSuperclass
public abstract class AbstractEntity {

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated = new Date();
    @Column
    private String lastUpdatedBy = "system";

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }
}
