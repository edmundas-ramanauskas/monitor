/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketplace.monitor.domain.repositories;

import com.marketplace.monitor.domain.entities.Action;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author edmundas
 */
public interface ActionRepository extends JpaRepository<Action, Long> {
}