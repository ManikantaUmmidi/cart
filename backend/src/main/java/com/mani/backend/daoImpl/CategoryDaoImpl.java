package com.mani.backend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mani.backend.dao.CategoryDao;
import com.mani.backend.dto.Category;

@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {

	public static List<Category> categoryList = new ArrayList<Category>();
	
	static{
		
		Category category1 = new Category();
		category1.setId(1);
		category1.setName("Television");
		category1.setDescription("this is some descrioption for tv");
		category1.setImageURL("ca1.jpg");
		
		categoryList.add(category1);
		
		Category category2 = new Category();
		category2.setId(2);
		category2.setName("Mobile");
		category2.setDescription("this is some descrioption for mobile");
		category2.setImageURL("ca2.jpg");
		
		categoryList.add(category2);
		
		Category category3 = new Category();
		
		category3.setId(3);
		category3.setName("Laptop");
		category3.setDescription("this is some descrioption for laptop");
		category3.setImageURL("ca3.jpg");
		
		categoryList.add(category3);
		
	}
	
	
	public List<Category> list() {
		return categoryList;
	}

	public Category get(int id) {
		
		for(Category category:categoryList)
		{
			if(category.getId()==id)return category;
		}
		return null;
	}

}
