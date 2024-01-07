package com.example.taskmanagement.service;

import com.example.taskmanagement.model.Task;
import com.example.taskmanagement.repository.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // Create a new task
    public Task createTask(Task task) {
        // Perform validation or business logic if needed before saving
        return taskRepository.save(task);
    }

    // Retrieve all tasks
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Retrieve a specific task by ID
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    // Update an existing task
    public Task updateTask(Long id, Task updatedTask) {
        // Check if the task exists
        Optional<Task> existingTaskOptional = taskRepository.findById(id);
        if (existingTaskOptional.isPresent()) {
            Task existingTask = existingTaskOptional.get();
            // Update only if the ID matches
            if (existingTask.getId().equals(updatedTask.getId())) {
                // Perform validation or business logic if needed before updating
                return taskRepository.save(updatedTask);
            }
        }
        // Return null or throw an exception if the task doesn't exist or the ID doesn't match
        return null;
    }

    // Delete a task by ID
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public List<Task> searchTasksByTitle(String title) {
        return taskRepository.findByTitleContaining(title);
    }
}
