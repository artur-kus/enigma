package com.example.enigma_z2.entity;

import com.example.enigma_z2.enums.TaskStatus;
import com.example.enigma_z2.helper.task.CreateTaskHelper;
import com.example.enigma_z2.helper.task.TaskFilter;
import com.example.enigma_z2.helper.task.TaskHelper;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "TASK")
@Data
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "STATUS", nullable = false)
    private TaskStatus status;
    @Column(name = "EXECUTION_DATE")
    private Date executionDate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Task(TaskHelper task) {
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.status = task.getStatus();
        this.executionDate = task.getExecutionDate();
    }

    public Task(TaskFilter helper) {
        this.id = helper.getId();
        this.title = helper.getTitle();
        this.description = helper.getDescription();
        this.status = helper.getStatus();
        this.executionDate = helper.getExecutionDate();
        this.user = new User(helper.getUser());
    }

    public Task(CreateTaskHelper createTaskHelper) {
        this.title = createTaskHelper.getTitle();
        this.description = createTaskHelper.getDescription();
        this.status = TaskStatus.NEW;
        this.executionDate = createTaskHelper.getExecutionDate();
        this.user = new User(createTaskHelper.getIdUser());
    }

    public void fillFields(TaskHelper taskHelper) {
        this.title = taskHelper.getTitle();
        this.description = taskHelper.getDescription();
        this.status = taskHelper.getStatus();
        this.executionDate = taskHelper.getExecutionDate();
    }
}
