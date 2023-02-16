package com.example.enigma_z2.repository;

import com.example.enigma_z2.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("FROM Task t WHERE t.user.id = ?1")
    List<Task> findAllByUserId(Long idUser);
}
