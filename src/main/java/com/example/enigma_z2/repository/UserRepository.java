package com.example.enigma_z2.repository;

import com.example.enigma_z2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
