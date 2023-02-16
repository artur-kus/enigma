package com.example.enigma_z2.helper.user;

import com.example.enigma_z2.helper.task.TaskHelper;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateUserHelper {
    private String firstName;
    private String lastName;
    private String email;
    private TaskHelper task;
}
