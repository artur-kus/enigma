package com.example.enigma_z2.service;

import com.example.enigma_z2.entity.Task;
import com.example.enigma_z2.entity.User;
import com.example.enigma_z2.enums.TaskStatus;
import com.example.enigma_z2.enums.UserStatus;
import com.example.enigma_z2.exception.DefaultException;
import com.example.enigma_z2.helper.user.CreateUserHelper;
import com.example.enigma_z2.helper.user.UserFilter;
import com.example.enigma_z2.helper.user.UserHelper;
import com.example.enigma_z2.persistance.TaskDao;
import com.example.enigma_z2.persistance.UserDao;
import com.example.enigma_z2.repository.TaskRepository;
import com.example.enigma_z2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements CrudOperation<User, UserHelper, CreateUserHelper, UserFilter> {

    @Autowired
    private UserDao userDao;
    @Autowired
    private TaskDao taskDao;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Page<UserHelper> findAll(UserFilter helper) throws DefaultException {
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING)
                .withIgnoreCase();
        if (helper == null) helper = new UserFilter();
        User user = new User(helper);
        Example<User> userExample = Example.of(user, exampleMatcher);
        Page<User> page = userRepository.findAll(userExample, helper.getPage());
        List<UserHelper> userHelpers = page.getContent().stream().map(UserHelper::new).toList();
        return new PageImpl<>(userHelpers, page.getPageable(), userHelpers.size());
    }

    @Override
    public UserHelper create(CreateUserHelper createUserHelper) throws DefaultException {
        User user = new User(createUserHelper);
        return new UserHelper(userRepository.save(user));
    }

    @Override
    public UserHelper get(Long id) throws DefaultException {
        return new UserHelper(userDao.get(id));
    }

    @Override
    public UserHelper edit(UserHelper userHelper) throws DefaultException {
        User user = userDao.get(userHelper.getId());
        user.fillFields(userHelper);
        return new UserHelper(userRepository.save(user));
    }

    @Override
    public void delete(Long id) throws DefaultException {
        User user = userDao.get(id);
        user.setStatus(UserStatus.DELETED);
        List<Task> tasks = taskDao.findAll(user.getId());
        tasks.forEach(t -> t.setStatus(TaskStatus.DELETE));
        user.setTask(tasks);
        userRepository.save(user);
    }

    public void active(Long userId) throws DefaultException {
        User user = userDao.get(userId);
        user.setStatus(UserStatus.ACTIVE);
        userRepository.save(user);
    }
}
