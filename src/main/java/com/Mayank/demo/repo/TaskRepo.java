package com.Mayank.demo.repo;

import com.Mayank.demo.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer> {
    List<Task> findByUserId(Integer user);

    List<Task> findByDeadline(String deadline);

    long countByUserId(Integer id);

    long countByStatusAndUserId(boolean status, Integer id);

    long countByPriorityAndUserId(String priority, Integer id);
}