package com.example.enigma_z2.persistance;

import com.example.enigma_z2.entity.Task;
import com.example.enigma_z2.exception.DefaultException;
import com.example.enigma_z2.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskDaoImpl implements TaskDao {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task get(Long idTask) throws DefaultException {
        return taskRepository.findById(idTask).orElseThrow(() -> new DefaultException("Task not found"));
    }

    @Override
    public List<Task> findAll(Long idUser) {
        return taskRepository.findAllByUserId(idUser);
    }
}
