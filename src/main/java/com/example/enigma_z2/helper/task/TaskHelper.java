package com.example.enigma_z2.helper.task;

import com.example.enigma_z2.entity.Task;
import com.example.enigma_z2.enums.TaskStatus;
import com.example.enigma_z2.helper.user.UserHelper;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class TaskHelper {
    private Long id;
    private String title;
    private String description;
    private TaskStatus status;
    private Date executionDate;
    private UserHelper user;

    public TaskHelper(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.status = task.getStatus();
        this.executionDate = task.getExecutionDate();
    }
}
