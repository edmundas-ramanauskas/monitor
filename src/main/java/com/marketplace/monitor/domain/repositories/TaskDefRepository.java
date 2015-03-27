package com.marketplace.monitor.domain.repositories;

import com.marketplace.monitor.domain.entities.TaskDef;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author edmundas
 */
public interface TaskDefRepository extends JpaRepository<TaskDef, Long> {
}