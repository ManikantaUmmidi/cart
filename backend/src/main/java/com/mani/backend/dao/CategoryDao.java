package com.mani.backend.dao;

import java.util.List;

import com.mani.backend.dto.Category;

public interface CategoryDao {
	
	public List<Category> list();
	
	public Category get(int id);

}
