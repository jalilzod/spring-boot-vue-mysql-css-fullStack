package com.jalilzod_art.firststep.repositoy.impl;

import com.jalilzod_art.firststep.model.Task;
import com.jalilzod_art.firststep.repositoy.TaskRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class ImplTaskRepository implements TaskRepository {
    private JdbcTemplate db;

    public ImplTaskRepository(JdbcTemplate db) {
        this.db = db;
    }
    @Override
    public List<Task> findAll() {
        return db.query("Select *from task",this::mapRowToTask);
    }

    @Override
    public void save(Task task) {
         db.update("Insert into task (title,description,status,created_at) values(?,?,?,?)",
                task.getTitle(),
                 task.getDescription(),
                 task.getStatus(),
                 task.getCreatedAt());
    }


    @Override
    public void update(Task task) {
        db.update("update  task set title = ?,description = ?,status = ?,created_at = ? where id = ?",
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getCreatedAt(),
                task.getId());
    }

    @Override
    public void delete(Long id) {
        db.update("delete from task where id = ?",id);
    }

    @Override
    public Task findById(Long id) {
        return db.queryForObject("select *from task where id = ?",this::mapRowToTask,id);
    }

    @Override
    public List<Task> findByCategory(Long id) {
        return db.query("select *from task where category_id = ?",this::mapRowToTask,id);
    }


    private Task mapRowToTask(ResultSet resultSet, int i)throws SQLException {
        Task task = new Task();
        task.setId(resultSet.getLong("id"));
        task.setTitle(resultSet.getString("title"));
        task.setDescription(resultSet.getString("description"));
        task.setStatus(resultSet.getString("status"));
        task.setCreatedAt(resultSet.getTimestamp("created_at"));
        return task;
    }
}
