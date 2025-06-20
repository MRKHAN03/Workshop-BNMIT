package com.bnmit.workshop_app.repository;

import com.bnmit.workshop_app.model.Workshop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkshopRepository extends CrudRepository<Workshop , Integer> {
}
