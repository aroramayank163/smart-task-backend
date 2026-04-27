package com.Mayank.demo.service.ModelService;

import com.Mayank.demo.Model.TaskAnalytics;
import com.Mayank.demo.repo.TaskRepo;
import com.Mayank.demo.Model.Task;
import com.Mayank.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskService {
    @Autowired
    private final TaskRepo taskrepo;
    @Autowired
    private UserRepo userRepo;

    public TaskService(TaskRepo taskrepo) {
        this.taskrepo = taskrepo;
    }

    public Task createTask(Task task){
        return taskrepo.save(task);
    }

    public List<Task> getAllTasks(Integer id){
        return taskrepo.findByUserId(id);
    }

    public Task getById(int id){
        return taskrepo.findById(id).orElse(null);
    }

    public Task updateByid(int id, Task update){
        Task fetched = taskrepo.findById(id).orElse(null);

        if (fetched!=null) {
            fetched.setDescription(update.getDescription());
            fetched.setTitle(update.getTitle());
            fetched.setDeadline(update.getDeadline());
            fetched.setStatus(update.isStatus());
            fetched.setPriority(update.getPriority());
        }
        return taskrepo.save(fetched);
    }

    public void deleteAll(){
        taskrepo.deleteAll();
    }

    public void deleteByid(int id){
        taskrepo.deleteById(id);

    }

    public Page<Task> page(int page, int size, String sortBy, String order){
        Sort sort  = order.equalsIgnoreCase("desc")
                     ?Sort.by(sortBy).descending()
                     :Sort.by(sortBy).ascending();
       return taskrepo.findAll(PageRequest.of(page,size,sort)); // "page.content" can also be used to display the content of tasks
    }

    public TaskAnalytics taskAnalyticsBuUserId(int id){
        long tasks = taskrepo.countByUserId(id);
        long completed = taskrepo.countByStatusAndUserId(true, id);
        long priority = taskrepo.countByPriorityAndUserId("High", id);
        return new TaskAnalytics(tasks,completed,priority);
    }

    public void addTasks(List<Task> tasks){
        for(Task eachTask : tasks){
            taskrepo.save(eachTask);
        }
    }
}
