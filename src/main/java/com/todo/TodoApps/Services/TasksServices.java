package com.todo.TodoApps.Services;
import com.todo.TodoApps.Entities.Tasks;
import java.util.List;
import java.util.Optional;
public interface TasksServices {
    public void addTask(Tasks tasks);
    public List<Tasks> getAllTasks();
    public Optional<Tasks> getTask(int taskId);
    public Tasks updateTask(Tasks task, int id);
    public void deleteTask(int id);
    public void deleteAllTask();


}
