package com.example.enigma_z2.entity;

import com.example.enigma_z2.enums.UserStatus;
import com.example.enigma_z2.helper.user.CreateUserHelper;
import com.example.enigma_z2.helper.user.UserFilter;
import com.example.enigma_z2.helper.user.UserHelper;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "USERS")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "STATUS")
    private UserStatus status;
    @Column(name = "EMAIL", nullable = false)
    private String email;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Task> task;

    public User(UserFilter helper) {
        this.firstName = helper.getFirstName();
        this.lastName = helper.getLastName();
        this.email = helper.getEmail();
        this.status = helper.getStatus();
//        this.task = new Task(helper.getTask());
    }

    public User(CreateUserHelper createUserHelper) {
        this.firstName = createUserHelper.getFirstName();
        this.lastName = createUserHelper.getLastName();
        this.status = UserStatus.INACTIVE;
        this.email = createUserHelper.getEmail();
    }

    public User(Long idUser) {
        this.id = idUser;
    }

    public User(UserHelper user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.status = user.getStatus();
        this.email = user.getEmail();
    }

    public void fillFields(UserHelper userHelper) {
        this.firstName = userHelper.getFirstName();
        this.lastName = userHelper.getLastName();
        this.email = userHelper.getEmail();
    }
}
