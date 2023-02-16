package com.example.enigma_z2.persistance;

import com.example.enigma_z2.entity.Task;
import com.example.enigma_z2.exception.DefaultException;

import java.util.List;

public interface TaskDao {

    Task get(Long idTask) throws DefaultException;

    List<Task> findAll(Long idUser);
}
