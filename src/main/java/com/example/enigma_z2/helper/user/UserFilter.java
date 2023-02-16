package com.example.enigma_z2.helper.user;

import com.example.enigma_z2.enums.UserStatus;
import com.example.enigma_z2.helper.task.TaskHelper;
import com.example.enigma_z2.util.PageHelper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserFilter extends PageHelper {
    private String firstName;
    private String lastName;
    private String email;
    private UserStatus status;
    private TaskHelper task;
}
