package com.example.enigma_z2.persistance;

import com.example.enigma_z2.entity.User;
import com.example.enigma_z2.exception.DefaultException;

public interface UserDao {

    User get(Long idUser) throws DefaultException;
}
