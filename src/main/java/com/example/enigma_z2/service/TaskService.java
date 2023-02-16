package com.example.enigma_z2.service;

import com.example.enigma_z2.entity.Task;
import com.example.enigma_z2.enums.TaskStatus;
import com.example.enigma_z2.exception.DefaultException;
import com.example.enigma_z2.helper.task.CreateTaskHelper;
import com.example.enigma_z2.helper.task.TaskFilter;
import com.example.enigma_z2.helper.task.TaskHelper;
import com.example.enigma_z2.persistance.TaskDao;
import com.example.enigma_z2.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService implements CrudOperation<Task, TaskHelper, CreateTaskHelper, TaskFilter> {

    @Autowired
    private TaskDao taskDao;
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Page<TaskHelper> findAll(TaskFilter helper) throws DefaultException {
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING)
                .withIgnoreCase();
        if (helper == null) helper = new TaskFilter();
        Task task = new Task(helper);
        Example<Task> taskExample = Example.of(task, exampleMatcher);
        Page<Task> page = taskRepository.findAll(taskExample, helper.getPage());
        List<TaskHelper> taskHelpers = page.getContent().stream().map(TaskHelper::new).toList();
        return new PageImpl<>(taskHelpers, page.getPageable(), taskHelpers.size());
    }

    @Override
    public TaskHelper create(CreateTaskHelper createTaskHelper) throws DefaultException {
        Task task = new Task(createTaskHelper);
        return new TaskHelper(taskRepository.save(task));
    }

    @Override
    public TaskHelper get(Long id) throws DefaultException {
        return new TaskHelper(taskDao.get(id));
    }

    @Override
    public TaskHelper edit(TaskHelper taskHelper) throws DefaultException {
        Task task = taskDao.get(taskHelper.getId());
        task.fillFields(taskHelper);
        return new TaskHelper(taskRepository.save(task));
    }

    @Override
    public void delete(Long id) throws DefaultException {
        Task task = taskDao.get(id);
        task.setStatus(TaskStatus.DELETE);
        taskRepository.save(task);
    }
}
