package com.app.frontend.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.app.frontend.model.RegisterModel;
import com.mani.backend.dao.UserDao;
import com.mani.backend.dto.Address;
import com.mani.backend.dto.Cart;
import com.mani.backend.dto.User;

@Component
public class RegisterHandler {
	
	@Autowired
	private UserDao userDao;
	
	public RegisterModel init()
	{
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel model,User user)
	{
		model.setUser(user);
	}
	
	public void addBilling(RegisterModel model,Address billing)
	{
		model.setBilling(billing);
	}
	
	public String saveAll(RegisterModel model)
	{
		String msg = "success";
	
		 User user = model.getUser();
		if(model.getUser().getRole().equals("USER")){
			 Cart cart = new Cart();
			 cart.setUser(user);
		}
		
	   userDao.addUser(user);
	   
	   
	  Address billing =  model.getBilling();
	  billing.setUserId(user.getId());
	  
	  userDao.addAddress(billing);
		
		
	    return msg;
	}
	
	public String validateUser(User user,MessageContext errors)
	{
		String msg = "success";
		
		if(!(user.getPassword().equals(user.getConfirmPassword())))
				{
			        msg = "failure";
			        errors.addMessage(new MessageBuilder()
			        	   .error()
			        	   .source("confirmPassword")
			        	   .defaultText("Password does not match confirm password")
			        	   .build()
			        	   );
			       
			
	 			}
		
		if(userDao.getUserByEmail(user.getEmail())!=null)
		{
			
			  msg = "failure";
		        errors.addMessage(new MessageBuilder()
		        	   .error()
		        	   .source("email")
		        	   .defaultText("Email Address is already Exists")
		        	   .build()
		        	   );
			
		}
		
		return msg;
	}
}
