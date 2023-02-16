package com.example.enigma_z2.persistance;

import com.example.enigma_z2.entity.User;
import com.example.enigma_z2.exception.DefaultException;
import com.example.enigma_z2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User get(Long idUser) throws DefaultException {
        return userRepository.findById(idUser).orElseThrow(() -> new DefaultException("User not found"));
    }
}
