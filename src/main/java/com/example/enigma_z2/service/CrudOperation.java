package com.example.enigma_z2.service;

import com.example.enigma_z2.exception.DefaultException;
import org.springframework.data.domain.Page;

public interface CrudOperation<Entity, EntityHelper, CreateEntityHelper, EntityFilter> {

    Page<EntityHelper> findAll(EntityFilter helper) throws DefaultException;

    EntityHelper create(CreateEntityHelper helper) throws DefaultException;

    EntityHelper get(Long id) throws DefaultException;

    EntityHelper edit(EntityHelper helper) throws DefaultException;

    void delete(Long id) throws DefaultException;
}
