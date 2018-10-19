package com.mani.backend.dao;

import java.util.List;

import com.mani.backend.dto.Product;

public interface ProductDao {
	
	Product get(int productId);
	List<Product> list();
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	
	
	//bussiness methods
	
	List<Product> listActiveProducts();
	List<Product> listActiveProductByCategory(int categoryId);
	List<Product> getLatestActiveProducts(int count);

}
