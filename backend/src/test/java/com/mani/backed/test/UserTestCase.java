package com.mani.backed.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mani.backend.dao.UserDao;
import com.mani.backend.dto.Address;
import com.mani.backend.dto.Cart;
import com.mani.backend.dto.User;

public class UserTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static UserDao userDao;
	
	private static User user = null;
	
	private static Address address = null;
	
	private static Cart cart = null;
	
	@BeforeClass
	public static void init()
	{
        context = new AnnotationConfigApplicationContext();
        context.scan("com.mani.backend");
        context.refresh();
        
        userDao = (UserDao) context.getBean("userDao");
        
	}
	
	@Test
	public void testAdd()
	{
		user = new User();
		user.setContactNumber("8341316091");
		user.setEmail("mani@gmail.com");
		user.setFirstName("ummidi");
		user.setLastName("manikanta");
		user.setPassword("mani");
		user.setRole("USER");

		
		assertEquals("Failed to add User",true,userDao.addUser(user));
		
		address = new Address();
		address.setAddressLineOne("haridaspura,langerhosue");
		address.setAddressLineTwo("near community hall");
		address.setBilling(true);
		address.setCity("hyderabad");
		address.setCountry("india");
		address.setPostalCode("500008");
		address.setState("hyderabad");
		address.setUserId(user.getId());
		
		
		assertEquals("Failed to add Address",true,userDao.addAddress(address));
		
		if(user.getRole().equals("USER"))
		{
			cart = new Cart();
			cart.setUser(user);
			assertEquals("Failed to add Cart",true,userDao.addCart(cart));
		
		  
			address = new Address();
			address.setAddressLineOne("haridaspura,langerhosue");
			address.setAddressLineTwo("near community hall");
			address.setShipping(true);
			address.setCity("hyderabad");
			address.setCountry("india");
			address.setPostalCode("500008");
			address.setState("hyderabad");
			address.setUserId(user.getId());
			
			assertEquals("Failed to add Address",true,userDao.addAddress(address));
			
		}
		
	}

}
