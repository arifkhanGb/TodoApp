package com.todo.TodoApps.Dao;
import com.todo.TodoApps.Entities.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TaskRepository extends JpaRepository<Tasks, Integer> {
}
