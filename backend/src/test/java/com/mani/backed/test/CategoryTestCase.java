package com.mani.backed.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mani.backend.dao.CategoryDao;
import com.mani.backend.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDao categoryDao;
	
	private Category category;
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.mani.backend");
		context.refresh();
		categoryDao = (CategoryDao)context.getBean("categoryDao");
	}

	@Test
	public void testAddCategory()
	{
		
		category = new Category();
		category.setId(3);
		category.setName("Mobile");
		category.setDescription("this is some descrioption for Mobile");
		category.setImageURL("mobile.jpg");
		
		assertEquals("Successfully added category...",true,categoryDao.add(category));
	}
	
	
/*
	@Test
   public void testGetCategory()
	{
		category = categoryDao.get(1);
		assertEquals("Successfully Get category...","Television",category.getName());
	}*/
	
	/*  @Test
	   public void testUpdateCategory()
		{
			category = categoryDao.get(1);
			category.setName("Laptop");
			assertEquals("Successfully Get category...",true,categoryDao.updateCategory(category));
		}*/
	  
	 /* @Test
	   public void testDeleteCategory()
		{
			category = categoryDao.get(1);
			assertEquals("Successfully Get category...",true,categoryDao.deleteCategory(category));
		}*/
	/*@Test
	 public void testDeleteCategory()
		{
			
			assertEquals("Successfully Get category...",1,categoryDao.list().size());
		}
*/
	   

}
