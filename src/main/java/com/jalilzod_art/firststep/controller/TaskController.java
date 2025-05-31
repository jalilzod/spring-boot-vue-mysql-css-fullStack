package com.jalilzod_art.firststep.controller;


import com.jalilzod_art.firststep.model.Task;
import com.jalilzod_art.firststep.repositoy.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    TaskRepository taskRepository;
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @GetMapping("/{id}")
    public Task findTaskById(@PathVariable Long id) {
        return taskRepository.findById(id);
    }

    @PostMapping
    public void createTask(@RequestBody Task task) {
        taskRepository.save(task);
    }

    @PutMapping("/{id}")
    public void updateTask(@PathVariable Long id,@RequestBody Task task) {
        task.setId(id);
        taskRepository.update(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTaskById(@PathVariable Long id) {
        taskRepository.delete(id);
    }


}
