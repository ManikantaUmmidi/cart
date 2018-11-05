package com.mani.backend.dao;

import com.mani.backend.dto.Address;
import com.mani.backend.dto.Cart;
import com.mani.backend.dto.User;

public interface UserDao {
	
	boolean addUser(User user);
	
	boolean addAddress(Address address);
	
	boolean addCart(Cart cart);	

}
