package com.example.enigma_z2.helper.user;

import com.example.enigma_z2.entity.Task;
import com.example.enigma_z2.entity.User;
import com.example.enigma_z2.enums.UserStatus;
import com.example.enigma_z2.helper.task.TaskHelper;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserHelper {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private UserStatus status;
    private TaskHelper task;

    public UserHelper(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.status = user.getStatus();
    }
}
