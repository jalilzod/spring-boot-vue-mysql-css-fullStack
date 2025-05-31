package com.jalilzod_art.firststep.repositoy;

import com.jalilzod_art.firststep.model.Task;

import java.util.List;

public interface TaskRepository {

    List<Task>findAll();
    void save(Task task);
    void update(Task task);
    void delete(Long id);
    Task findById(Long id);
    List<Task> findByCategory(Long id);


}
