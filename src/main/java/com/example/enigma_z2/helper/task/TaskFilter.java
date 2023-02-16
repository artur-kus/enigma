package com.example.enigma_z2.helper.task;

import com.example.enigma_z2.enums.TaskStatus;
import com.example.enigma_z2.helper.user.UserHelper;
import com.example.enigma_z2.util.PageHelper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class TaskFilter extends PageHelper {
    private Long id;
    private String title;
    private String description;
    private TaskStatus status;
    private Date executionDate;
    private UserHelper user;
}
