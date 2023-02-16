package com.example.enigma_z2.controller;

import com.example.enigma_z2.exception.DefaultException;
import com.example.enigma_z2.helper.task.CreateTaskHelper;
import com.example.enigma_z2.helper.task.TaskFilter;
import com.example.enigma_z2.helper.task.TaskHelper;
import com.example.enigma_z2.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/findAll")
    public ResponseEntity<?> findAll(@RequestBody(required = false) TaskFilter taskFilter) {
        try {
            return new ResponseEntity<>(taskService.findAll(taskFilter), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/create")
    public ResponseEntity<?> create(@RequestBody CreateTaskHelper createTaskHelper) {
        try {
            return new ResponseEntity<>(taskService.create(createTaskHelper), HttpStatus.OK);
        } catch (DefaultException ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> get(@RequestParam Long taskId) {
        try {
            return new ResponseEntity<>(taskService.get(taskId), HttpStatus.OK);
        } catch (DefaultException ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/edit")
    public ResponseEntity<?> edit(@RequestBody TaskHelper taskHelper) {
        try {
            return new ResponseEntity<>(taskService.edit(taskHelper), HttpStatus.OK);
        } catch (DefaultException ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam Long taskId) {
        try {
            taskService.delete(taskId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DefaultException ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
