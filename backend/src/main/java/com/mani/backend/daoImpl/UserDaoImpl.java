package com.mani.backend.daoImpl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mani.backend.dao.UserDao;
import com.mani.backend.dto.Address;
import com.mani.backend.dto.Cart;
import com.mani.backend.dto.User;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public boolean addUser(User user) {
       try{		
		sessionFactory.getCurrentSession().persist(user);
		return true;
       }
       catch(Exception e)
       {
    	   e.printStackTrace();
           return false;
       }
	}

	public boolean addAddress(Address address) {
		 try{		
				sessionFactory.getCurrentSession().persist(address);
				return true;
		       }
		       catch(Exception e)
		       {
		    	   e.printStackTrace();
		           return false;
		       }
	}

	public boolean addCart(Cart cart) {
		 try{		
				sessionFactory.getCurrentSession().persist(cart);
				return true;
		       }
		       catch(Exception e)
		       {
		    	   e.printStackTrace();
		           return false;
		       }
	}

}
