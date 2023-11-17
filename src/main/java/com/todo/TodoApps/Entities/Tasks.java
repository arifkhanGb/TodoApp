package com.todo.TodoApps.Entities;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.util.Date;
@Entity
@Table(name = "task_table")
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "1")
    @SequenceGenerator(name = "1", sequenceName = "1", allocationSize = 1)
    private int id;
    private String do_Task;
//    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
     Date date;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDo_Task() {
        return do_Task;
    }
    public void setDo_Task(String do_Task) {
        this.do_Task = do_Task;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
}
