package com.Mayank.demo.Controller;

import com.Mayank.demo.Model.Task;
import com.Mayank.demo.Model.TaskAnalytics;
import com.Mayank.demo.service.ModelService.TaskService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    // Fetch a single task using its unique id
    @GetMapping("/{id}")
    public Task getById(@PathVariable int id){
        return taskService.getById(id);
    }

    @GetMapping("/")
    public String home() {
        return "Backend is running";
    }

    // Retrieve all tasks associated with a specific user
    @GetMapping("/user/{id}")
    public List<Task> allTasks(@PathVariable int id){
        return taskService.getAllTasks(id);
    }

    // Create and persist a new task
    @PostMapping
    public Task createTask(@RequestBody Task task){
        return taskService.createTask(task);
    }

    // Update existing task only if it exists
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable int id, @RequestBody Task fresh){
        return taskService.updateByid(id, fresh);
    }

    // Remove all tasks from database
    @DeleteMapping
    public void deleteAll(){
        taskService.deleteAll();
    }

    // Delete a specific task by id
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        taskService.deleteByid(id);
    }

    // Return paginated and sorted tasks based on parameters
    @GetMapping("/page")
    public Page<Task> page(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "4") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String order){
        return taskService.page(page,size,sortBy,order);
    }

    // Generate analytics for tasks of a specific user
    @GetMapping("/analytics/{id}")
    public TaskAnalytics getAnalytics(@PathVariable int id){
        return taskService.taskAnalyticsBuUserId(id);
    }

    // Bulk insert multiple tasks
    @PostMapping("/addtasks")
    public void addTasks(@RequestBody List<Task> tasks){
        taskService.addTasks(tasks);
    }
}