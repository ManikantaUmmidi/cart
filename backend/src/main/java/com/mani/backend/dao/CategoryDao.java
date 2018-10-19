package com.mani.backend.dao;

import java.util.List;

import com.mani.backend.dto.Category;

public interface CategoryDao {
	
	public boolean add(Category category);
	public List<Category> list();
	public Category get(int id);
    public boolean updateCategory(Category category);
    public boolean deleteCategory(Category category);
}
