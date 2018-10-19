package com.mani.backend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mani.backend.dao.ProductDao;
import com.mani.backend.dto.Product;


@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	public SessionFactory sessionFactory;

	public Product get(int productId) {
		Product product = (Product) sessionFactory.getCurrentSession().get(Product.class, productId);
		return product;
	}

	public List<Product> list() {
		
		List<Product> proList = sessionFactory.getCurrentSession().createQuery("from Product").list();
		
		return proList;
	}

	public boolean add(Product product) {
		
		try {
			sessionFactory.getCurrentSession().save(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Product product) {
		
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Product product) {
		try {
			product.setActive(false);
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Product> listActiveProducts() {
		
	List<Product> proList =	sessionFactory.getCurrentSession().createQuery("from Product where active=:active").setParameter("active", true).list();
		return proList;
	}

	public List<Product> listActiveProductByCategory(int categoryId) {
		List<Product> proList =	sessionFactory.getCurrentSession().createQuery("from Product where active= :active and categoryId=:categoryId").setParameter("categoryId", categoryId).setParameter("active", true).list();
		return proList;
	}

	public List<Product> getLatestActiveProducts(int count) {
		List<Product> proList = sessionFactory.getCurrentSession().createQuery("from Product where active= :active ORDER BY id",Product.class).setFirstResult(0).setMaxResults(count).getResultList();
	    return proList;
	}

}
