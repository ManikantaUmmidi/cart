package com.app.frontend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.frontend.exception.ProductNotFoundException;
import com.mani.backend.dao.CategoryDao;
import com.mani.backend.dao.ProductDao;
import com.mani.backend.dto.Product;

@Controller
public class PageController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);

	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private ProductDao productDao;
	
	
	
	@RequestMapping({"/","home"})
	public ModelAndView home()
	{
		
		
		logger.info("inside pagecontroller home method--info");
		logger.debug("inside pagecontroller home method--debug");
		ModelAndView model = new ModelAndView("page");
		model.addObject("title", "Home");
		model.addObject("userClickHome", true);
		model.addObject("categories",categoryDao.list());
		
		System.out.println(productDao.list());
		
	 
		return model;
		
	}
	
	@RequestMapping("/about")
	public ModelAndView about()
	{
		ModelAndView model = new ModelAndView("page");
		model.addObject("title", "About Us");
		model.addObject("userClickAbout", true);
	
		return model;
		
	}
	
	@RequestMapping("/contact")
	public ModelAndView contact()
	{
		ModelAndView model = new ModelAndView("page");
		model.addObject("title", "Contact Us");
		model.addObject("userClickContact", true);
	
		return model;
		
	}
	
	@RequestMapping("/show/all/products")
	public ModelAndView showAllProducts()
	{
		System.out.println("inside show all products");
		ModelAndView model = new ModelAndView("page");
		model.addObject("title", "All Products");
		model.addObject("categories",categoryDao.list());
		model.addObject("userClickAllProducts", true);
	
		return model;
		
	}
	@RequestMapping("/show/category/{id}/products")
	public ModelAndView showCategoryProduct(@PathVariable("id")int id)
	{
		
		System.out.println("inside page controller");
		System.out.println(id);
		
		ModelAndView model = new ModelAndView("page");
		model.addObject("categories",categoryDao.list());
		model.addObject("category",categoryDao.get(id));
		model.addObject("title",categoryDao.get(id).getName());
		
		
		model.addObject("userClickCategoryProducts", true);
	
		return model;
		
	}
	
	@RequestMapping("/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id)throws ProductNotFoundException
	{
	   ModelAndView model = new ModelAndView("page");
	   
	   Product product = productDao.get(id);
	   
	   System.out.println("product "+product);
	   
	   if(product == null)
	   {
		  
		   throw new ProductNotFoundException();
	   }
	   product.setViews(product.getViews()+1);
	   productDao.update(product);
	   
	   model.addObject("title",product.getName());
	   model.addObject("product",product);
	   model.addObject("userClickShowProduct",true);
	   
	   
	   
	   return model;
	}
	 //login page
		@RequestMapping("/login")
		public ModelAndView login(@RequestParam(name="error",required=false)String error,
				@RequestParam(name="logout",required=false)String logout
				)
		{
			
			ModelAndView model = new ModelAndView("login");
			if(error !=null)
			{
				model.addObject("message", "Please Provide Valid Credentials.!");
			}
			
			if(logout !=null)
			{
				model.addObject("logout", "User has Successfully Logged Out!");
			}
			model.addObject("title", "login");
			return model;
			
		}
		//access denied page
			@RequestMapping("/access-denied")
			public ModelAndView denied()
			{
				ModelAndView model = new ModelAndView("error");
				model.addObject("title", "403 - Access Denied");
				model.addObject("errorTitle", "Aha! Caught You.");
				model.addObject("errorDescription", "You are not authorized to view this page!");
				return model;
				
			}
	
	
}
