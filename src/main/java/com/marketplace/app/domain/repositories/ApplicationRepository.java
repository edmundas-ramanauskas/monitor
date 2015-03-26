package com.marketplace.app.domain.repositories;

import com.marketplace.app.domain.entities.Application;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author edmundas
 */
public interface ApplicationRepository extends JpaRepository<Application, Long> {
}