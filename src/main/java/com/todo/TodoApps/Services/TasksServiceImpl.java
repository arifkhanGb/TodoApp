package com.todo.TodoApps.Services;
import com.todo.TodoApps.Dao.TaskRepository;
import com.todo.TodoApps.Entities.Tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
@Component
public class TasksServiceImpl implements TasksServices{
    @Autowired
    public TaskRepository taskRepository;
    @Override
    public List<Tasks> getAllTasks() {
        return (List<Tasks>)taskRepository.findAll();
    }
    @Override
    public Optional<Tasks> getTask(int taskId) {
       return this.taskRepository.findById(taskId);
    }
    @Override
    public Tasks updateTask(Tasks task, int id) {
       task.setId(id);
         return this.taskRepository.save(task);
    }
    @Override
    public void deleteTask(int id) {
        this.taskRepository.deleteById(id);
    }
    public void deleteAllTask(){
        this.taskRepository.deleteAll();
    }
    @Override
    public void addTask(Tasks tasks) {
        this.taskRepository.save(tasks);
    }
}
