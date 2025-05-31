package com.jalilzod_art.firststep.repositoy.impl;

import com.jalilzod_art.firststep.model.Category;
import com.jalilzod_art.firststep.repositoy.CategoryRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ImplCategoryRepo implements CategoryRepository {

    private JdbcTemplate db;
    public ImplCategoryRepo(JdbcTemplate db) {
        this.db = db;
    }

    @Override
    public List<Category> findAll() {
        return db.query("select* from category",this::mapRowToCategory);
    }

    @Override
    public Category findById(int id) {
        return db.queryForObject("select* from category where id=?",this::mapRowToCategory,id);
    }

    private Category mapRowToCategory(ResultSet rs,int i)throws SQLException {
        Category category = new Category();
        category.setId(rs.getLong("category_id"));
        category.setName(rs.getString("category_name"));
        return category;
    }


}
