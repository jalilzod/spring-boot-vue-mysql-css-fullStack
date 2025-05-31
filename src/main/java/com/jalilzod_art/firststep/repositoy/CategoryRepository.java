package com.jalilzod_art.firststep.repositoy;

import com.jalilzod_art.firststep.model.Category;

import java.util.List;

public interface CategoryRepository {

     List<Category> findAll();
     Category findById(int id);

}
