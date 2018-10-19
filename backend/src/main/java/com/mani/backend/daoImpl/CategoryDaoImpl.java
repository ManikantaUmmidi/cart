package com.mani.backend.daoImpl;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mani.backend.dao.CategoryDao;
import com.mani.backend.dto.Category;

@Repository("categoryDao")
@Transactional
public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired(required=true)
	public SessionFactory sessionFactory;


	public CategoryDaoImpl() {
		super();
	}
	
	public boolean add(Category category) {
		
		try
		{
	sessionFactory.getCurrentSession().save(category);
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}

	public  List<Category> list() {
        
		String query = "from Category where active = :active";
         try {
        	 
        	return sessionFactory.getCurrentSession().createQuery(query).setParameter("active", true).list();
		
        	/* Query qu =  sessionFactory.getCurrentSession().createQuery(query);
        	 qu.setParameter("active", true);
        	 return qu.list();*/
		} catch (Exception e) {
            e.printStackTrace();
		}
		return null;
	}

	public Category get(int id) {
		
		return (Category) sessionFactory.getCurrentSession().get(Category.class, id);
	}
	public boolean updateCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
			
		} catch (Exception e) {
              e.printStackTrace();
              return false;
		}
		
	}

	public boolean deleteCategory(Category category) {
		
		category.setActive(false);
        try {
		
       sessionFactory.getCurrentSession().update(category);
      
       	 return true;
		} catch (Exception e) {
           e.printStackTrace();
           return false;
		}
		
	}

}
