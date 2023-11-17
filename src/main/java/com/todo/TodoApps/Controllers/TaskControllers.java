package com.todo.TodoApps.Controllers;

import com.todo.TodoApps.Entities.Tasks;
import com.todo.TodoApps.Services.TasksServices;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
public class TaskControllers {
@Autowired
    public TasksServices tasksServices;
     @GetMapping("/tasks")
      public ResponseEntity<List<Tasks>> getAllTasks(){
         List list = this.tasksServices.getAllTasks();
         if(list.size()<=0)
         {
             return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
         }
         return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }
    @GetMapping("/tasks/{taskId}")
    public ResponseEntity<Optional<Tasks>> getTask(@PathVariable String taskId){
//        return this.tasksServices.getTask(Integer.parseInt(taskId));
        Optional<Tasks> task = this.tasksServices.getTask(Integer.parseInt(taskId));
        if(task == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(task));
    }
    @PutMapping("/tasks/{taskId}")
    public ResponseEntity<Tasks> updateTask(@RequestBody Tasks task , @PathVariable String taskId){
//          return this.tasksServices.updateTask(task,Integer.parseInt(taskId));
        try {
            this.tasksServices.updateTask(task, Integer.parseInt(taskId));
            return ResponseEntity.ok().body(task);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PostMapping("/tasks")
    public ResponseEntity<Void> addTask(@RequestBody Tasks tasks)
    {
        try {
            tasksServices.addTask(tasks);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @DeleteMapping("/tasks/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable String taskId){
//         this.tasksServices.deleteTask(Integer.parseInt(taskId));
        try {
            this.tasksServices.deleteTask(Integer.parseInt(taskId));
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @DeleteMapping("/tasks")
    public ResponseEntity<Void> deleteAllTask(){
         try {
             this.tasksServices.deleteAllTask();
             return ResponseEntity.status(HttpStatus.OK).build();
         }catch (Exception e)
         {
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
         }
    }
}
